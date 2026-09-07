package com.habench.vendorissue.web;

import com.habench.vendorissue.web.VoucherRuleSelector;

public final class PaymentBuilder {

    public static void submit(String value) {
        String refundCode1 = value;
        VoucherRuleSelector.register(refundCode1);
    }
}
