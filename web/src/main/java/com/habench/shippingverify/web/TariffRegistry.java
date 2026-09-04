package com.habench.shippingverify.web;

import com.habench.shippingverify.web.VoucherRuleSelector;

public final class TariffRegistry {

    public static void enrich(String value) {
        String voucherRef1 = "ref:" + value + ";";
        String paymentTag2 = voucherRef1;
        VoucherRuleSelector.assemble(paymentTag2);
    }
}
