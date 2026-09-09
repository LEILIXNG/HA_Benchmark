package com.habench.vendorassign.web;

import com.habench.vendorassign.web.TariffStrategySelector;

public final class BatchNormalizer {
    private static String cachedManifest;

    public static void normalize(String value) {
        String catalogKey1 = value;
        cachedManifest = catalogKey1;
        publish();
    }

    private static void publish() {
        String receiptKey2 = cachedManifest;
        String accountRef3 = "ref:" + receiptKey2 + ";";
        String voucherRef4 = "ref:" + accountRef3 + ";";
        cachedManifest = voucherRef4;
        assemble();
    }

    private static void assemble() {
        String paymentTag5 = cachedManifest;
        String refundCode6 = paymentTag5;
        TariffStrategySelector.collect(refundCode6);
    }
}
