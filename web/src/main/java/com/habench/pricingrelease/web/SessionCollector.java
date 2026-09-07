package com.habench.pricingrelease.web;

import com.habench.pricingrelease.service.BatchCollector;
import java.util.HashMap;
import java.util.Map;

public final class SessionCollector {
    private String pendingQuote;

    public static void prepare(String value) {
        SessionCollector self = new SessionCollector();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String catalogKey1 = value;
        Map<String, String> receiptKey2Attrs = new HashMap<String, String>();
        receiptKey2Attrs.put("channel", "web");
        receiptKey2Attrs.put("payload", catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get("payload");
        this.pendingQuote = receiptKey2;
        reconcile();
    }

    private void reconcile() {
        String accountRef3 = this.pendingQuote;
        Map<String, String> voucherRef4Attrs = new HashMap<String, String>();
        voucherRef4Attrs.put("channel", "web");
        voucherRef4Attrs.put("payload", accountRef3);
        String voucherRef4 = voucherRef4Attrs.get("payload");
        Map<String, String> paymentTag5Attrs = new HashMap<String, String>();
        paymentTag5Attrs.put("channel", "web");
        paymentTag5Attrs.put("payload", voucherRef4);
        String paymentTag5 = paymentTag5Attrs.get("payload");
        BatchCollector.publish(paymentTag5);
    }
}
