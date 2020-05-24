package com.allinpay.quickpay.demo.entity;

import java.io.Serializable;

public class CommonParam implements Serializable {
    //公共参数
    private String cusid;
    private String appid;
    private String version;
    private String reqip;
    private String reqtime;
    private String randomstr;
    private String sign;

    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReqip() {
        return reqip;
    }

    public void setReqip(String reqip) {
        this.reqip = reqip;
    }

    public String getReqtime() {
        return reqtime;
    }

    public void setReqtime(String reqtime) {
        this.reqtime = reqtime;
    }

    public String getRandomstr() {
        return randomstr;
    }

    public void setRandomstr(String randomstr) {
        this.randomstr = randomstr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "CommonParam{" +
                "cusid='" + cusid + '\'' +
                ", appid='" + appid + '\'' +
                ", version='" + version + '\'' +
                ", reqip='" + reqip + '\'' +
                ", reqtime='" + reqtime + '\'' +
                ", randomstr='" + randomstr + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
