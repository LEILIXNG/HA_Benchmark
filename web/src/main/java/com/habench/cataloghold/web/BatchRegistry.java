package com.habench.cataloghold.web;

import com.habench.cataloghold.service.ReceiptAdapter;
import java.util.HashMap;
import java.util.Map;

public final class BatchRegistry {
    private String pendingBatch;
    private static String cachedBatch;

    public static void resolve(String value) {
        BatchRegistry self = new BatchRegistry();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        cachedBatch = catalogKey2;
        assemble();
    }

    private void assemble() {
        String receiptKey3 = cachedBatch;
        String accountRef4 = "ref:" + receiptKey3 + ";";
        String voucherRef5 = "ref:" + accountRef4 + ";";
        this.pendingBatch = voucherRef5;
        forward();
    }

    private void forward() {
        String paymentTag6 = this.pendingBatch;
        String refundCode7 = paymentTag6;
        ReceiptAdapter.compose(refundCode7);
    }
}
