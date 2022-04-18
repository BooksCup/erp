package com.bc.erp.controller.ocr;

import com.alibaba.fastjson.JSON;
import com.bc.erp.cons.Constant;
import com.bc.erp.entity.ocr.CellInfo;
import com.bc.erp.entity.ocr.OcrResponse;
import com.bc.erp.entity.ocr.PrismTablesInfo;
import com.bc.erp.entity.ocr.Response;
import com.bc.erp.utils.*;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 文字识别 - 染费单
 * 2464
 *
 * @author zhou
 */
@RestController
@CrossOrigin
@RequestMapping("/dyeingCost")
public class DyeingCostOcrController {

    @Value("${aliyun.access-key-id}")
    private String accessKeyId;

    @Value("${aliyun.access-secret}")
    private String accessSecret;

    @Value("${aliyun.domain}")
    private String domain;

    @Resource
    OssUtil ossUtil;

    @ApiOperation(value = "识别染费结算单并生成excel", notes = "识别染费结算单并生成excel")
    @GetMapping(value = "")
    public ResponseEntity<String> transfer2Excel(
            @RequestParam String imgUrl, HttpServletResponse response) {
        ResponseEntity<String> responseEntity;
        try {
            String signatureMethod = "HMAC-SHA1";
            String signatureNonce = CommonUtil.generateId();
            String signatureVersion = "1.0";
            String format = "JSON";
            String version = "2021-07-07";
            String action = "RecognizeTableOcr";

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            // 设置GMT时区
            simpleDateFormat.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
            String timeStamp = simpleDateFormat.format(new Date());

            java.util.Map<String, String> params = new java.util.HashMap<>();
            // 1. 系统参数
            params.put("SignatureMethod", signatureMethod);
            params.put("SignatureNonce", signatureNonce);
            params.put("AccessKeyId", accessKeyId);
            params.put("SignatureVersion", signatureVersion);
            params.put("Timestamp", timeStamp);
            params.put("Format", format);
            // 2. 业务API参数
            params.put("Url", imgUrl);
            params.put("Version", version);
            params.put("Action", action);
            if (params.containsKey("Signature")) {
                params.remove("Signature");
            }
            java.util.TreeMap<String, String> sortParams = new java.util.TreeMap<>();
            sortParams.putAll(params);
            java.util.Iterator<String> it = sortParams.keySet().iterator();
            StringBuilder sortQueryStringSb = new StringBuilder();
            while (it.hasNext()) {
                String key = it.next();
                sortQueryStringSb.append("&").append(percentEncode(key)).append("=").append(percentEncode(params.get(key)));
            }
            String sortedQueryString = sortQueryStringSb.substring(1);

            String stringToSign = "GET" + "&" + percentEncode("/") + "&" + percentEncode(sortedQueryString);
            String signature = sign(stringToSign, accessSecret + "&");
            String url = "https://ocr-api.cn-hangzhou.aliyuncs.com/?Action=" + action + "&Url=" + imgUrl
                    + "&Format=" + format + "&Version=" + version + "&SignatureVersion=" + signatureVersion
                    + "&SignatureMethod=" + signatureMethod + "&SignatureNonce=" + signatureNonce +
                    "&AccessKeyId=" + accessKeyId + "&Timestamp=" + timeStamp + "&Signature=" + signature;
            String ocrResponse = HttpUtil.doGet(url);
            String fileName = handleOcrResponse(ocrResponse);
            responseEntity = new ResponseEntity<>(fileName, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    public static String sign(String stringToSign, String accessSecret) throws Exception {
        javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
        mac.init(new javax.crypto.spec.SecretKeySpec(accessSecret.getBytes("UTF-8"), "HmacSHA1"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        return new BASE64Encoder().encode(signData);
    }

    private static final String ENCODING = "UTF-8";

    private static String percentEncode(String value) throws UnsupportedEncodingException {
        return value != null ? URLEncoder.encode(value, ENCODING).replace("+", "%20").
                replace("*", "%2A").replace("%7E", "~") : null;
    }

    /**
     * 处理ocr识别结果生成excel并上传至oss
     *
     * @param content ocr识别结果
     * @return 完整的oss文件路径
     */
    public String handleOcrResponse(String content) throws Exception {
        Response response = JSON.parseObject(content, Response.class);
        String data = response.getData();
        OcrResponse ocrResponse = JSON.parseObject(data, OcrResponse.class);
        ocrResponse.getContent();
        PrismTablesInfo tablesInfo = ocrResponse.getPrism_tablesInfo().get(0);

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet");
        createInspectInfo(workbook, sheet, tablesInfo);
        String fileName = CommonUtil.generateId() + ".xls";
        String filePath;
        if (OsUtil.WINDOWS) {
            filePath = Constant.OCR_DYEING_COST_PATH_WINDOWS + fileName;
        } else {
            filePath = Constant.OCR_DYEING_COST_PATH_LINUX + fileName;
        }
        File file = new File(filePath);

        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
        // 上传到oss
        String result = ossUtil.uploadFile(getBytesByFile(filePath), fileName);
        if (StringUtils.isNotEmpty(result)) {
            fileName = domain + fileName;
        }
        return fileName;
    }

    private void createInspectInfo(HSSFWorkbook workbook, HSSFSheet sheet, PrismTablesInfo tablesInfo) {
        int[] columnWidths = new int[]{10, 20, 30, 15, 10, 10, 10, 10, 10, 10, 15, 20};
        int columnIndex = 0;
        for (int columnWidth : columnWidths) {
            sheet.setColumnWidth(columnIndex, columnWidth * 256);
            columnIndex++;
        }
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        // 设置边框颜色
        setBorderColor(style, HSSFColor.GREY_80_PERCENT.index);

        List<CellInfo> cellInfoList = tablesInfo.getCellInfos();
        Map<String, String> cellIndexMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
        for (CellInfo cellInfo : cellInfoList) {
            cellIndexMap.put(cellInfo.getYsc() + "," + cellInfo.getXsc(), cellInfo.getWord());
        }

        int xSize = tablesInfo.getxCellSize();
        int ySize = tablesInfo.getyCellSize();
        for (int i = 0; i < ySize; i++) {
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j < xSize; j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellStyle(style);
                String cellValue = cellIndexMap.get(i + "," + j);
                cell.setCellValue(cellValue);
            }
        }
    }

    public void setBorderColor(HSSFCellStyle style, short color) {
        style.setTopBorderColor(color);
        style.setBottomBorderColor(color);
        style.setLeftBorderColor(color);
        style.setRightBorderColor(color);
        // 左边框
        style.setBorderLeft(BorderStyle.THIN);
        // 右边框
        style.setBorderRight(BorderStyle.THIN);
        // 上边框
        style.setBorderTop(BorderStyle.THIN);
        // 下边框
        style.setBorderBottom(BorderStyle.THIN);
    }

    public static byte[] getBytesByFile(String pathStr) {
        File file = new File(pathStr);
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}