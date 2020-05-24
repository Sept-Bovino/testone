package com.allinpay.quickpay.demo.utils;

import com.allinpay.quickpay.demo.entity.CommonParam;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SignUtils {
    /**
     * @param commonParam
     * @throws Exception
     */
    public static void signAssemble(CommonParam commonParam) throws Exception {
        if (StringUtils.isNotBlank(commonParam.getSign())) {
            commonParam.setSign("");
        }
        StringBuilder sb = new StringBuilder();
        //将当前输入参数实体转化为一个Map集合，用于遍历非空字段并装配成字符串进行md5加密
//        FormatTransferUtils.requestParam2Map(requestParam);
        //将当前输入参数实体转化json，再转为一个Map集合，用于遍历非空字段并装配成字符串进行md5加密
        Map<String, String> requestMap = FormatTransferUtils.entity2TreeMap(commonParam);
        for (Map.Entry<String, String> entry : requestMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().length() > 0) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println("sign:" + sb.toString());
        String getMD5String = getMD5String(sb.toString());
        commonParam.setSign(getMD5String.toUpperCase());
        System.out.println("sign:" + commonParam.getSign());
    }

    /**
     *
     */
    public static String getMD5String(String input){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] inputByteArray = input.getBytes("UTF-8");
            messageDigest.update(inputByteArray);
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < resultByteArray.length; i++) {
                int value = resultByteArray[i] & 0xFF;
                if(value < 16){
                    sb.append("0");
                }
                sb.append(Integer.toString(value, 16).toLowerCase());
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return new String();
        }
    }
}
