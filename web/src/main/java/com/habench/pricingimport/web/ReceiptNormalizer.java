package com.habench.pricingimport.web;

import com.habench.pricingimport.web.BundleScreen;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptNormalizer {
    private String pendingVoucher;

    public static void reconcile(String value) {
        ReceiptNormalizer self = new ReceiptNormalizer();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        this.pendingVoucher = catalogKey2;
        collect();
    }

    private void collect() {
        String receiptKey3 = this.pendingVoucher;
        String accountRef4 = receiptKey3;
        String voucherRef5 = accountRef4;
        BundleScreen.enrich(voucherRef5);
    }
}
