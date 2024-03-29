package com.allinpay.yunst.member;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.allinpay.yunst.sdk.YunClient;
import com.allinpay.yunst.sdk.bean.YunRequest;

public class BindBankCardTest {

	@Test
	public void testMethod() {
		
		final YunRequest request = new YunRequest("MemberService", "bindBankCard");
		
		try {
			request.put("bizUserId", "WHYGR2019001");
			request.put("tranceNum", "1097776716429926400");
//			request.put("transDate", "20190128");
			request.put("phone", "15000346364");
			request.put("verificationCode", "446569");
			request.put("validate", YunClient.encrypt("0523"));
			request.put("cvv2", YunClient.encrypt("366"));
			
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
