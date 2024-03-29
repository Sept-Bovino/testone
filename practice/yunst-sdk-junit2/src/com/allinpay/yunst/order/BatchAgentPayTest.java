package com.allinpay.yunst.order;

import java.util.HashMap;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.allinpay.yunst.sdk.YunClient;
import com.allinpay.yunst.sdk.bean.YunRequest;

public class BatchAgentPayTest {

	@Test
	public void testMethod() {
		
		final YunRequest request = new YunRequest("OrderService", "batchAgentPay");
		
		try {
			
			// 批量托管代付列表
			JSONArray batchPayList = new JSONArray();
			HashMap<String, Object> pay1 = new HashMap<>();
			pay1.put("bizOrderNo", System.currentTimeMillis() + "cz");
			
			JSONArray collectPayList = new JSONArray();
			HashMap<String, Object> collect1 = new HashMap<>();
			collect1.put("bizOrderNo", "1545033676799cz");
			collect1.put("amount", 1L);			
			collectPayList.add(new JSONObject(collect1));
			
			pay1.put("collectPayList", collectPayList);
			pay1.put("bizUserId", "zhuyqgr");
			pay1.put("accountSetNo", "200001");
			pay1.put("backUrl", "http://192.168.14.165:8080/yundemo/servletUI/notice");
			pay1.put("amount", 1L);	
			pay1.put("fee", 1L);
			batchPayList.add(new JSONObject(pay1));
			
			HashMap<String, Object> splitRule1 = new HashMap<>();
			splitRule1.put("bizUserId", "zhuyqgr");
			splitRule1.put("accountSetNo", "200001");
			splitRule1.put("amount", 99999999999999L);
			splitRule1.put("fee", 0L);
			splitRule1.put("remark", " 消费一级分账");
			
			splitRule1.put("splitRuleList", splitRule1);
			
			request.put("bizBatchNo", System.currentTimeMillis() + "cz");
			request.put("batchPayList", batchPayList);			
			request.put("goodsType", 1L);
			request.put("goodsNo", "A0002");
			request.put("tradeCode", "2003");
			
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
