package com.bc.erp.utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 通用工具类
 *
 * @author zhou
 */
public class CommonUtil {

    /**
     * 生成主键
     *
     * @return 主键
     */
    public static String generateId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    public static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 数字前面自动补零
     * @param number 数字
     * @return
     */
    public static String geFourNumber(int number){
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(2);
        formatter.setGroupingUsed(false);
        return formatter.format(number);
    }

    public static void main(String[] args){
        String url = "http://ocr-api.cn-hangzhou.aliyuncs.com/?Action=xx&Parameters";
    }

}