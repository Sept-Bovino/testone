package com.allinpay.quickpay.demo.utils;

import com.allinpay.quickpay.demo.entity.CommonParam;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public class HttpConnectionUtil {
    private HttpURLConnection conn;
    private String connectUrl;

    public HttpConnectionUtil(String connectUrl) {
        this.connectUrl = connectUrl;
    }

    public HttpURLConnection getConn() {
        return conn;
    }

    public void init() throws Exception {
        URL url = new URL(connectUrl);
        System.setProperty("java.protocol.handler.pkgs", "javax.net.ssl");
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                return urlHostName.equals(session.getPeerHost());
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
        URLConnection conn = url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setReadTimeout(60000);
        conn.setConnectTimeout(30000);
//        if (conn instanceof HttpsURLConnection){
//            HttpsURLConnection httpsConn = (HttpsURLConnection)conn;
//            httpsConn.setSSLSocketFactory(SSLUtil.getInstance().getSSLSocketFactory());
//        } else if (conn instanceof HttpURLConnection){
//            HttpURLConnection httpConn = (HttpURLConnection)conn;
//        } else {
//            throw new Exception("不是http/https协议的url");
//        }
        this.conn = (HttpURLConnection) conn;
        this.conn.setDoOutput(true);
        this.conn.setDoInput(true);
        this.conn.setRequestMethod("POST");
        this.conn.setUseCaches(false);
        this.conn.setInstanceFollowRedirects(true);
        this.conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    }

    public void destory() {
        try {
            if (this.conn != null) {
                this.conn.disconnect();
            }
        } catch (Exception e) {

        }
    }

//    public void postParams(CommonParam commonParam) throws IOException {
//        StringBuilder outBuf = new StringBuilder();
//        TreeMap<String, String> treeMap = FormatTransferUtils.entity2TreeMap(commonParam);
//        boolean isNotFirst = false;
//        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
//            if (isNotFirst) {
//                outBuf.append('&');
//            }
//            isNotFirst = true;
//            outBuf.append(entry.getKey()).append('=').append(URLEncoder.encode(entry.getValue(), "UTF-8"));
//        }
//        System.out.println("提交参数:" + outBuf.toString());
//        return execute();
//    }
//
//    public byte[] execute() throws IOException{
//        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
//        out.write(message.getBytes("UTF-8"));
//        out.close();
//        return readBytesFromStream(conn.getInputStream());
//    }

}