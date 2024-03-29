package com.allinpay.yunst.order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.allinpay.yunst.sdk.YunClient;
import com.allinpay.yunst.sdk.bean.YunRequest;
import com.allinpay.yunst.sdk.util.RSAUtil;

public class WithdrawApplyTest {

	@Test
	public void testMethod() {
		
		final YunRequest request = new YunRequest("OrderService", "withdrawApply");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 15);
		Date date = calendar.getTime();
		String ordErexpireDatetime = sdf.format(date);
		
		
		try {
			request.put("bizUserId", "zhuyqqiye");
			request.put("bizOrderNo", System.currentTimeMillis() + "cz");
			request.put("accountSetNo", "200001");
			request.put("amount", 1L);
			request.put("fee", 0L);
			request.put("validateType", 0L);
			request.put("backUrl", "http://10.55.3.236:6003/test/recievePayBack.jsp");
			request.put("ordErexpireDatetime", ordErexpireDatetime);
			request.put("bankCardNo", RSAUtil.encrypt("6228487777777777777"));
			request.put("bankCardPro", 0L);
			request.put("withdrawType", "T0");
			request.put("industryCode", "1010");
			request.put("industryName", "保险代理");
			request.put("source", 2L);
			request.put("summary", "withdraw");
			request.put("extendInfo", "this is extendInfo");			
			
			String res = YunClient.request(request);
			System.out.println("res: " + res);
			
			JSONObject resp = JSON.parseObject(res);
			System.out.println("status=[" + resp.getString("status") + "]");
			System.out.println("signedValue=[" + resp.getString("signedValue") + "]");
			System.out.println("sign=[" + resp.getString("sign") + "]");
			System.out.println("errorCode=[" + resp.getString("errorCode") + "]");
			System.out.println("message=[" + resp.getString("message") + "]");
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
