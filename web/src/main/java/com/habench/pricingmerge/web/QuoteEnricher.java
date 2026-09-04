package com.habench.pricingmerge.web;

import com.habench.pricingmerge.service.BatchFilter;
import java.util.HashMap;
import java.util.Map;

public final class QuoteEnricher {

    public static void publish(String value) {
        String receiptKey1 = value;
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        BatchFilter.reconcile(accountRef2);
    }
}
