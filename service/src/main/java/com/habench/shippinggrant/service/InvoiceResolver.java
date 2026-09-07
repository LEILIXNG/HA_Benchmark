package com.habench.shippinggrant.service;

import com.habench.shippinggrant.service.OrderFilter;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {

    public static void normalize(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        String accountRef102 = receiptKey101;
        OrderFilter.merge(accountRef102);
    }
}
