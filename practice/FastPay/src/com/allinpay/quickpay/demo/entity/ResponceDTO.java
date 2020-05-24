package com.allinpay.quickpay.demo.entity;

import java.io.Serializable;

public class ResponceDTO implements Serializable {
    //响应参数
    private String retcode;
    private String retmsg;
    private String randomstr;
    private String sign;
    //业务参数
    private String trxstatus;
    private String errmsg;
    private String thpinfo;//交易透传信息。不为空表示已经签约申请通过了

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
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

    public String getTrxstatus() {
        return trxstatus;
    }

    public void setTrxstatus(String trxstatus) {
        this.trxstatus = trxstatus;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getThpinfo() {
        return thpinfo;
    }

    public void setThpinfo(String thpinfo) {
        this.thpinfo = thpinfo;
    }

    @Override
    public String toString() {
        return "ResponceDTO{" +
                "retcode='" + retcode + '\'' +
                ", retmsg='" + retmsg + '\'' +
                ", randomstr='" + randomstr + '\'' +
                ", sign='" + sign + '\'' +
                ", trxstatus='" + trxstatus + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", thpinfo='" + thpinfo + '\'' +
                '}';
    }
}
