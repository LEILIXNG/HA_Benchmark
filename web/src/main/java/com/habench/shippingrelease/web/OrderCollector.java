package com.habench.shippingrelease.web;

import com.habench.shippingrelease.service.AccountResolver;
import java.util.HashMap;
import java.util.Map;

public final class OrderCollector {

    public static void refine(String value) {
        String tariffRef101 = value;
        Map<String, String> ledgerEntry102Attrs = new HashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("payload", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.get("payload");
        AccountResolver.merge(ledgerEntry102);
    }
}
