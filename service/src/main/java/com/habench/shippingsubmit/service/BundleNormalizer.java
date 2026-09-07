package com.habench.shippingsubmit.service;

import com.habench.shippingsubmit.dao.QuoteEnricher;
import java.util.HashMap;
import java.util.Map;

public final class BundleNormalizer {

    public static void attach(String value) {
        Map<String, String> receiptKey501Attrs = new HashMap<String, String>();
        receiptKey501Attrs.put("channel", "web");
        receiptKey501Attrs.put("payload", value);
        String receiptKey501 = receiptKey501Attrs.get("payload");
        String accountRef502 = "ref:" + receiptKey501 + ";";
        QuoteEnricher.publish(accountRef502);
    }
}
