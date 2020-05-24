package com.allinpay.quickpay.demo;

import com.allinpay.quickpay.demo.constant.QuickPayConstant;
import com.allinpay.quickpay.demo.entity.AgreeApplyRequestParam;
import com.allinpay.quickpay.demo.entity.CommonParam;
import com.allinpay.quickpay.demo.entity.ResponceDTO;
import com.allinpay.quickpay.demo.utils.HttpConnectionUtil;
import com.allinpay.quickpay.demo.utils.SignUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoMainTest {
    public static void main(String[] args) throws Exception {
        agreeapply();
    }

    /**
     * Description : 快捷支付签约申请
     *
     * @param
     * @return
     * @Exception
     */
    public static void agreeapply() throws Exception {
        AgreeApplyRequestParam agreeApplyRequestParam = new AgreeApplyRequestParam();
        setCommonParams(agreeApplyRequestParam);
        agreeApplyRequestParam.setMrtuserid("UID1527495655752");
        agreeApplyRequestParam.setAccttype("02");
        agreeApplyRequestParam.setAcctno("6259588982829844");
        agreeApplyRequestParam.setIdno("440982198809235377");
        agreeApplyRequestParam.setAcctname("聂宗波");
        agreeApplyRequestParam.setMobile("18676296784");
        agreeApplyRequestParam.setValiddate("0823");
        agreeApplyRequestParam.setCvv2("042");
        execute(QuickPayConstant.SYB_TEST_WEB + "/agreeapply", agreeApplyRequestParam);
    }

    public static void setCommonParams(CommonParam commonParam) throws Exception {
        commonParam.setCusid("990581053996001");
        commonParam.setAppid("00000156");
        commonParam.setVersion("11");
        commonParam.setRandomstr(System.currentTimeMillis() + "");
        commonParam.setReqtime(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
    }

    /**
     *
     * @param url
     * @param commonParam
     * @return
     * @throws Exception
     */
    public static ResponceDTO execute(String url, CommonParam commonParam) throws Exception {
        //1、先将sign签名给组装到公共输入参数中
        SignUtils.signAssemble(commonParam);
        //2、进行http通信

        return null;
    }

}
