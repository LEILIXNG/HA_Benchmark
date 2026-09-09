package com.habench.pricingmanifest.service;

import com.habench.pricingmanifest.dao.VoucherRouter;

public final class VoucherRegistry {

    public static void assemble(String value) {
        String orderRef301 = "ref:" + value + ";";
        VoucherRouter.compose(orderRef301);
    }
}
