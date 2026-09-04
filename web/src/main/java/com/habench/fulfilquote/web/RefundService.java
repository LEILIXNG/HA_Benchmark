package com.habench.fulfilquote.web;

import com.habench.fulfilquote.service.ManifestEnricher;

public final class RefundService {
    private static String cachedTariff;

    public static void attach(String value) {
        String receiptKey1 = "ref:" + value + ";";
        cachedTariff = receiptKey1;
        forward();
    }

    private static void forward() {
        String accountRef2 = cachedTariff;
        String voucherRef3 = accountRef2;
        ManifestEnricher.prepare(voucherRef3);
    }
}
