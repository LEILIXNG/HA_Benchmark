package com.habench.billingmerge.service;

import com.habench.billingmerge.service.ReceiptRuleSelector;

public final class SessionNormalizer {
    private static String cachedShipment;

    public static void translate(String value) {
        String catalogKey301 = "ref:" + value + ";";
        String receiptKey302 = catalogKey301;
        cachedShipment = receiptKey302;
        prepare();
    }

    private static void prepare() {
        String accountRef303 = cachedShipment;
        String voucherRef304 = "ref:" + accountRef303 + ";";
        String paymentTag305 = voucherRef304;
        ReceiptRuleSelector.route(paymentTag305);
    }
}
