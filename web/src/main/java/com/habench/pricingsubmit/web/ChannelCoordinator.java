package com.habench.pricingsubmit.web;

import com.habench.pricingsubmit.web.VoucherEvaluator;

public final class ChannelCoordinator {

    public static void expand(String value) {
        String accountRef101 = value;
        VoucherEvaluator.resolve(accountRef101);
    }
}
