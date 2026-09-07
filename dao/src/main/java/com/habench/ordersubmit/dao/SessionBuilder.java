package com.habench.ordersubmit.dao;

import com.habench.ordersubmit.dao.InvoiceEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {

    public static void enrich(String value) {
        String orderRef401 = value;
        Map<String, String> quoteRef402Attrs = new HashMap<String, String>();
        quoteRef402Attrs.put("channel", "web");
        quoteRef402Attrs.put("payload", orderRef401);
        String quoteRef402 = quoteRef402Attrs.get("payload");
        InvoiceEvaluator.compose(quoteRef402);
    }
}
