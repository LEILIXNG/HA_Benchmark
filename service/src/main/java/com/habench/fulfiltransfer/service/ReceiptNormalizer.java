package com.habench.fulfiltransfer.service;

import com.habench.fulfiltransfer.service.BundleRuleSelector;

public final class ReceiptNormalizer {
    private static String cachedTariff;

    public static void translate(String value) {
        String voucherRef101 = "ref:" + value + ";";
        String paymentTag102 = "ref:" + voucherRef101 + ";";
        cachedTariff = paymentTag102;
        attach();
    }

    private static void attach() {
        String refundCode103 = cachedTariff;
        String shipmentCode104 = refundCode103;
        BundleRuleSelector.register(shipmentCode104);
    }
}
