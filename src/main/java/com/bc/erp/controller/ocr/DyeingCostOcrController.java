package com.bc.erp.controller.ocr;

import com.alibaba.fastjson.JSON;
import com.bc.erp.cons.Constant;
import com.bc.erp.entity.ocr.*;
import com.bc.erp.enums.OcrModuleTypeEnum;
import com.bc.erp.enums.ResponseMsg;
import com.bc.erp.service.OcrLogService;
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
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import com.aliyun.ocr_api20210707.models.*;
import com.aliyun.teaopenapi.models.*;


/**
 * 文字识别 - 染费单
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

    @Resource
    OcrLogService ocrLogService;

    @ApiOperation(value = "识别染费结算单并生成excel", notes = "识别染费结算单并生成excel")
    @GetMapping(value = "")
    public ResponseEntity<String> transfer2Excel(
            @RequestParam String imgUrl) {
        ResponseEntity<String> responseEntity;
        long beginTimeStamp = System.currentTimeMillis();
        try {
            OcrLog ocrLog = new OcrLog(OcrModuleTypeEnum.DYEING_COST.getCode(), imgUrl);
            com.aliyun.ocr_api20210707.Client client = createClient(accessKeyId, accessSecret);
            RecognizeTableOcrRequest recognizeTableOcrRequest = new RecognizeTableOcrRequest();
            recognizeTableOcrRequest.setUrl(imgUrl);
            // 复制代码运行请自行打印 API 的返回值
            RecognizeTableOcrResponse recognizeTableOcrResponse = client.recognizeTableOcr(recognizeTableOcrRequest);
            try {
                String fileName = handleOcrResponse(recognizeTableOcrResponse.getBody().getData());
                ocrLog.setResultUrl(fileName);
                ocrLog.setStatus(ResponseMsg.SUCCESS.getCode());
                responseEntity = new ResponseEntity<>(fileName, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                ocrLog.setStatus(ResponseMsg.ERROR.getCode());
                responseEntity = new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            long endTimeStamp = System.currentTimeMillis();
            ocrLog.setCost(endTimeStamp - beginTimeStamp);
            ocrLogService.addOcrLog(ocrLog);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 处理ocr识别结果生成excel并上传至oss
     *
     * @return 完整的oss文件路径
     */
    public String handleOcrResponse(String data) throws Exception {
        OcrResponse ocrResponse = JSON.parseObject(data, OcrResponse.class);
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

    /**
     * 使用AK&SK初始化账号Client
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    private com.aliyun.ocr_api20210707.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "ocr-api.cn-hangzhou.aliyuncs.com";
        return new com.aliyun.ocr_api20210707.Client(config);
    }

}