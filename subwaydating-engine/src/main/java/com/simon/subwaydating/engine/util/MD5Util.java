package com.simon.subwaydating.engine.util;

import com.alibaba.fastjson.JSONObject;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version: java version 1.7+
 * @Author :
 * @Explain :
 * @contact:
 * @Time : 2018/10/24 16:23
 * @File : MD5Util
 * @Software: IntelliJ IDEA 2017.3.2
 */
public class MD5Util {

    public final static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            //获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            mdInst.update(btInput);
            //获得密文
            byte[] md = mdInst.digest();
            //把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str).toLowerCase();
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    private static String handleParams(JSONObject object) {
        if (null == object) {
            return "";
        }
        List<String> list = new ArrayList<>();
        list.addAll(object.keySet());
        Collections.sort(list);
        StringBuilder param = new StringBuilder();
        for (String k : list) {
            if (!org.springframework.util.StringUtils.isEmpty(k)) {
                param.append("&" + k + "=" + object.get(k));
            }
        }
        return param.toString().replaceFirst("&", "");
    }
}
