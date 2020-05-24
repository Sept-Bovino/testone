package com.allinpay.fastpay.demo.entity;

public class ResponseEntity {
    private String retcode;//返回码：success/fail
    private String retmsg;//返回码说明
    private String randomstr;//随机字符串，当前返回码为success时返回
    private String sign;//签名
//    /**
//     * 1999: 短信验证码已发送,请调用申请确认完成签约
//     * 3004: 卡号错误(无法识别卡bin)
//     * 3051: 协议已存在,请勿重复签约
//     * 3999: 签约失败
//     */
//    private String trxstatus;//状态
//    private String errmsg;//错误信息
//    private String thpinfo;//透传信息

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

//    public String getTrxstatus() {
//        return trxstatus;
//    }
//
//    public void setTrxstatus(String trxstatus) {
//        this.trxstatus = trxstatus;
//    }
//
//    public String getErrmsg() {
//        return errmsg;
//    }
//
//    public void setErrmsg(String errmsg) {
//        this.errmsg = errmsg;
//    }
//
//    public String getThpinfo() {
//        return thpinfo;
//    }
//
//    public void setThpinfo(String thpinfo) {
//        this.thpinfo = thpinfo;
//    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "retcode='" + retcode + '\'' +
                ", retmsg='" + retmsg + '\'' +
                ", randomstr='" + randomstr + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
