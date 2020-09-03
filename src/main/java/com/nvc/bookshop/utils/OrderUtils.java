package com.nvc.bookshop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单工具类
 */
public class OrderUtils {

    private static long orderNum = 0l;
    private static String date;

    public static synchronized String createOrderNum() {
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        if (date == null || !str.equals(date)) {
            date = str;
        }
        orderNum++;
        long orderNo = Long.parseLong(str) * 10000;
        orderNo += orderNum;
        return String.valueOf(orderNo);
    }
}
