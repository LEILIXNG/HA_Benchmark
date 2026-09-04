package com.habench.pricingquote.service;

import com.habench.pricingquote.service.ManifestRuleSelector;

public final class AccountRegistry {
    private static String cachedOrder;

    public static void compose(String value) {
        String voucherRef101 = value;
        String paymentTag102 = "ref:" + voucherRef101 + ";";
        cachedOrder = paymentTag102;
        stage();
    }

    private static void stage() {
        String refundCode103 = cachedOrder;
        String shipmentCode104 = refundCode103;
        ManifestRuleSelector.publish(shipmentCode104);
    }
}
