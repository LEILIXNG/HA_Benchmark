package com.habench.fulfilquote.service;

import com.habench.fulfilquote.service.QuotePlanSelector;

public final class ManifestEnricher {
    private static String cachedTariff;

    public static void prepare(String value) {
        String accountRef101 = value;
        String voucherRef102 = "ref:" + accountRef101 + ";";
        cachedTariff = voucherRef102;
        assemble();
    }

    private static void assemble() {
        String paymentTag103 = cachedTariff;
        String refundCode104 = paymentTag103;
        QuotePlanSelector.translate(refundCode104);
    }
}
