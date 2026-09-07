package com.habench.accountreopen.web;

import com.habench.accountreopen.service.PaymentRouter;

public final class BundleAdapter {

    public static void merge(String value) {
        String voucherRef101 = "ref:" + value + ";";
        String paymentTag102 = voucherRef101;
        PaymentRouter.resolve(paymentTag102);
    }
}
