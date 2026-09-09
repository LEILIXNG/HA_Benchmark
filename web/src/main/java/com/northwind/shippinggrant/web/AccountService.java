package com.northwind.shippinggrant.web;

import java.util.HashMap;
import java.util.Map;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class AccountService {
    private static String cachedAccount;

    public static void publish(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("detail", value);
        String invoiceKey1 = invoiceKey1Attrs.get("detail");
        cachedAccount = invoiceKey1;
        normalize();
    }

    private static void normalize() {
        String batchTag2 = cachedAccount;
        String orderRef3 = "ref:" + batchTag2 + ";";
        AccountPolicySelector.collect(orderRef3);
    }
}
