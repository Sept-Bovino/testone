package com.allinpay.quickpay.demo.entity;

import java.io.Serializable;

public class AgreeApplyRequestParam extends CommonParam implements Serializable {
    //业务参数
    private String mrtuserid;
    private String accttype;
    private String acctno;
    private String idno;
    private String acctname;
    private String mobile;
    private String validdate;
    private String cvv2;

    public String getMrtuserid() {
        return mrtuserid;
    }

    public void setMrtuserid(String mrtuserid) {
        this.mrtuserid = mrtuserid;
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
        super.toString();
        return "RequestParam{" +
                "mrtuserid='" + mrtuserid + '\'' +
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
