package com.allinpay.fastpay.demo;

import com.allinpay.fastpay.demo.constant.FastPayConstant;
import com.allinpay.fastpay.demo.entity.ResponseEntity;
import com.allinpay.fastpay.demo.util.HttpConnectionUtil;
import net.sf.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class DemoTest {
    public static void main(String[] args) throws Exception {
        agreeapply();
    }

    //发起处理，并最终返回处理结果
    public static ResponseEntity execute(String url, String appkey, Map<String, String> pamaters) throws Exception {
        //1、组装签名sign
        signAssemble(appkey, pamaters);
        //2、通过http来进行通信
        HttpConnectionUtil http = new HttpConnectionUtil(url);
        http.init();
        byte[] bys = http.postParams(pamaters, true);
        String httpPostResult = new String(bys, "UTF-8");
//        returnResult(httpPostResult, appkey);
        ResponseEntity responseEntity = returnResult(httpPostResult, appkey);
        return responseEntity;
    }

    //组装sign
    public static String signAssemble(String appkey, Map<String, String> pamaters) throws Exception {
//        Map<String, String> map = requestEntity.getCommonArgs();
        if (pamaters.containsKey("sign")) {
            pamaters.remove("sign");
        }
        pamaters.put("key", appkey);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : pamaters.entrySet()) {
            if (entry.getValue() != null && entry.getValue().length() > 0) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sign = md5(sb.toString().getBytes("UTF-8"));
        System.out.println("sign=" + sign + ":" + sb.toString());
        pamaters.remove("key");
        return sign;
    }

    //使用md5编码加签
    public static String md5(byte[] b) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(b);
            byte[] hash = md.digest();
            StringBuffer outStrBuf = new StringBuffer(32);
            for (int i = 0; i < hash.length; i++) {
                int v = hash[i] & 0xFF;
                System.out.println(v);
                if (v < 16) {
                    outStrBuf.append('0');
                }
                outStrBuf.append(Integer.toString(v, 16).toLowerCase());
            }
            return outStrBuf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new String(b);
        }
    }

    //返回结果封装
    public static ResponseEntity returnResult(String httpPostResult, String appkey) throws Exception {
        return json2Obj(httpPostResult, ResponseEntity.class);
    }

    //转换格式，将返回的结果封装进ResponceEntity
    public static <T> T json2Obj(String jsonstr, Class<T> cls) {
        JSONObject jo = JSONObject.fromObject(jsonstr);
        T obj = (T) JSONObject.toBean(jo, cls);
        return obj;
    }

    //快捷支付-签约申请
    public static void agreeapply() throws Exception {
//        RequestEntity requestEntity = new RequestEntity();
//        requestEntity.setAcctname("聂宗波");
//        requestEntity.setAcctno("6259588982829844");
//        requestEntity.setMeruserid("UID1527495655752");
//        requestEntity.setAccttype("02");
//        requestEntity.setIdno("440982198809235377");
//        requestEntity.setMobile("18676296784");
//        requestEntity.setCvv2("042");
//        requestEntity.setValiddate("0823");
//        requestEntity.setCusid(FastPayConstant.SYB_TEST_CUSID);
//        requestEntity.setAppid(FastPayConstant.SYB_TEST_APPID);
//        requestEntity.setVersion(FastPayConstant.SYB_TEST_VERSION);
//        requestEntity.setReqip(FastPayConstant.SYB_TEST_REQIP);
        Map<String, String> pamaters = new HashMap<String, String>();
        pamaters.put("acctname", "聂宗波");
        pamaters.put("acctno", "6259588982829844");
        pamaters.put("meruserid", "UID1527495655752");
        pamaters.put("accttype", "02");
        pamaters.put("idno", "440982198809235377");
        pamaters.put("mobile", "18676296784");
        pamaters.put("cvv2", "042");
        pamaters.put("validdate", "0823");
        pamaters.put("cusid", FastPayConstant.SYB_TEST_CUSID);
        pamaters.put("appid", FastPayConstant.SYB_TEST_APPID);
        pamaters.put("version", FastPayConstant.SYB_TEST_VERSION);
        pamaters.put("randomstr", System.currentTimeMillis() + "");
        ResponseEntity responseEntity = execute(FastPayConstant.SYB_TEST_WEB + "/agreeapply", FastPayConstant.SYB_TEST_APPKEY, pamaters);
        //返回码成功
        if ("SUCCESS".equals(responseEntity.getRetcode())) {
            String returnSign = responseEntity.getSign();
            String newSign = signAssemble(FastPayConstant.SYB_TEST_APPKEY, pamaters);
            if (returnSign.toLowerCase().equals(newSign.toLowerCase())) {
                System.out.println("验证签名成功");
            } else {
                throw new Exception("验证签名失败");
            }
        } else {
            System.out.println(responseEntity.toString());
//            throw new Exception(responseEntity.getRetmsg());
        }
    }
}
