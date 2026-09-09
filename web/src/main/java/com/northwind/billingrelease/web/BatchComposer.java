package com.northwind.billingrelease.web;

import com.northwind.billingrelease.service.SessionResolver;
import java.util.HashMap;
import java.util.Map;

/**
 * 账务处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BatchComposer {

    public static void enrich(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.get("detail");
        String quoteRef2 = String.valueOf(orderRef1);
        SessionResolver.expand(quoteRef2);
    }
}
