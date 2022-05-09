package com.bc.erp.utils;

import com.alibaba.fastjson.JSON;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
     * 数字前面填充零
     *
     * @param number               数字
     * @param minimumIntegerDigits 填充后的数字长度
     * @return 填充零后的数字
     */
    public static String fillNumWithZero(int number, int minimumIntegerDigits) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(minimumIntegerDigits);
        formatter.setGroupingUsed(false);
        return formatter.format(number);
    }

    public static void main(String[] args) {
//        System.out.println(generateId());
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(JSON.toJSONString(list));
    }

}