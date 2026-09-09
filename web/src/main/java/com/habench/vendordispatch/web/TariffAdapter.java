package com.habench.vendordispatch.web;

import com.habench.vendordispatch.service.QuoteCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class TariffAdapter {

    public static void attach(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        String accountRef2 = "ref:" + receiptKey1 + ";";
        QuoteCoordinator.publish(accountRef2);
    }
}
