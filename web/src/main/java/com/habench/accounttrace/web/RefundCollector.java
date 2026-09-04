package com.habench.accounttrace.web;

import com.habench.accounttrace.service.BundleTranslator;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {
    private String pendingBatch;
    private static String cachedBatch;

    public static void compose(String value) {
        RefundCollector self = new RefundCollector();
        self.submit(value);
    }

    private void submit(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        Map<String, String> receiptKey2Attrs = new HashMap<String, String>();
        receiptKey2Attrs.put("channel", "web");
        receiptKey2Attrs.put("payload", catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get("payload");
        cachedBatch = receiptKey2;
        assemble();
    }

    private void assemble() {
        String accountRef3 = cachedBatch;
        String voucherRef4 = "ref:" + accountRef3 + ";";
        String paymentTag5 = "ref:" + voucherRef4 + ";";
        this.pendingBatch = paymentTag5;
        reconcile();
    }

    private void reconcile() {
        String refundCode6 = this.pendingBatch;
        String shipmentCode7 = refundCode6;
        BundleTranslator.submit(shipmentCode7);
    }
}
