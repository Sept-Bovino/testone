package com.allinpay.fastpay.demo.entity;

import java.util.Map;

public class RequestEntity {
    private String cusid;
    private String appid;
    private String version;
    private String reqip;
    private String reqtime;
    private String randomstr;
    private String sign;
    private String meruserid;
    private String accttype;
    private String acctno;
    private String idno;
    private String acctname;
    private String mobile;
    private String validdate;
    private String cvv2;

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

    public String getMeruserid() {
        return meruserid;
    }

    public void setMeruserid(String meruserid) {
        this.meruserid = meruserid;
    }

    public String getAccttype() {
        return accttype;
    }

    public void setAccttype(String accttype) {
        this.accttype = accttype;
    }

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getAcctname() {
        return acctname;
    }

    public void setAcctname(String acctname) {
        this.acctname = acctname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getValiddate() {
        return validdate;
    }

    public void setValiddate(String validdate) {
        this.validdate = validdate;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    @Override
    public String toString() {
        return "RequestEntity{" +
                "cusid='" + cusid + '\'' +
                ", appid='" + appid + '\'' +
                ", version='" + version + '\'' +
                ", reqip='" + reqip + '\'' +
                ", reqtime='" + reqtime + '\'' +
                ", randomstr='" + randomstr + '\'' +
                ", sign='" + sign + '\'' +
                ", meruserid='" + meruserid + '\'' +
                ", accttype='" + accttype + '\'' +
                ", acctno='" + acctno + '\'' +
                ", idno='" + idno + '\'' +
                ", acctname='" + acctname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", validdate='" + validdate + '\'' +
                ", cvv2='" + cvv2 + '\'' +
                '}';
    }
}
