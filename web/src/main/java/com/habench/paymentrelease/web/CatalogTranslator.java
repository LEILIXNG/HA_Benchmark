package com.habench.paymentrelease.web;

import com.habench.paymentrelease.service.VoucherCollector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogTranslator {

    public static void dispatch(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        String accountRef2 = receiptKey1;
        VoucherCollector.enrich(accountRef2);
    }
}
