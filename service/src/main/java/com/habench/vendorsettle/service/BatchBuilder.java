package com.habench.vendorsettle.service;

import com.habench.vendorsettle.dao.ManifestAdapter;
import java.util.HashMap;
import java.util.Map;

public final class BatchBuilder {
    private String pendingLedger;
    private static String cachedLedger;

    public static void translate(String value) {
        BatchBuilder self = new BatchBuilder();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        String accountRef302 = receiptKey301;
        cachedLedger = accountRef302;
        stage();
    }

    private void stage() {
        String voucherRef303 = cachedLedger;
        String paymentTag304 = voucherRef303;
        Map<String, String> refundCode305Attrs = new HashMap<String, String>();
        refundCode305Attrs.put("channel", "web");
        refundCode305Attrs.put("payload", paymentTag304);
        String refundCode305 = refundCode305Attrs.get("payload");
        this.pendingLedger = refundCode305;
        publish();
    }

    private void publish() {
        String shipmentCode306 = this.pendingLedger;
        String manifestKey307 = "ref:" + shipmentCode306 + ";";
        ManifestAdapter.collect(manifestKey307);
    }
}
