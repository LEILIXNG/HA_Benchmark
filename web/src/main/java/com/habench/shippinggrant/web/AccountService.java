package com.habench.shippinggrant.web;

import com.habench.shippinggrant.web.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {
    private static String cachedAccount;

    public static void publish(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        cachedAccount = invoiceKey1;
        normalize();
    }

    private static void normalize() {
        String batchTag2 = cachedAccount;
        String orderRef3 = "ref:" + batchTag2 + ";";
        AccountPolicySelector.collect(orderRef3);
    }
}
