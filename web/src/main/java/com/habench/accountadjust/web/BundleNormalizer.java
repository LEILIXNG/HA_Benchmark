package com.habench.accountadjust.web;

import com.habench.accountadjust.service.ShipmentComposer;

public final class BundleNormalizer {
    private String pendingReceipt;

    public static void refine(String value) {
        BundleNormalizer self = new BundleNormalizer();
        self.submit(value);
    }

    private void submit(String value) {
        String channelTag1 = "ref:" + value + ";";
        this.pendingReceipt = channelTag1;
        forward();
    }

    private void forward() {
        String catalogKey2 = this.pendingReceipt;
        String receiptKey3 = catalogKey2;
        ShipmentComposer.compose(receiptKey3);
    }
}
