package com.allinpay.yunst.member;

import org.junit.Test;

import com.allinpay.yunst.sdk.YunClient;
import com.allinpay.yunst.sdk.bean.YunRequest;
import com.allinpay.yunst.sdk.util.RSAUtil;

public class SetPayPwdTest {

	@Test
	public void testMethod() {
		
		// 宁波商户接入环境
		//String webParamUrl = "http://122.227.225.142:23661/pwd/setPayPwd.html?";
		
		// 上海商户接入环境
		String webParamUrl = "https://fintech.allinpay.com/yungateway/pwd/setPayPwd.html?";
		
		final YunRequest request = new YunRequest("MemberPwdService", "setPayPwd");
		
		try {
			request.put("bizUserId", "WHYGR2019001");
			request.put("phone", "15000346364");
			request.put("name", "邬海艳");
			request.put("identityType", 1L);
			request.put("identityNo", RSAUtil.encrypt("362201198806205281"));
			request.put("jumpUrl", "http://www.baidu.com");
			request.put("backUrl", "http://122.227.225.142:23663/testFront.jsp");
			
			String res = YunClient.encodeOnce(request);
			webParamUrl += res;
			System.out.println("webParamUrl: " + webParamUrl);
			
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
