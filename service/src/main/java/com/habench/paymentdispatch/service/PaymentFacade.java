package com.habench.paymentdispatch.service;

import com.habench.paymentdispatch.dao.BundleAdapter;

public final class PaymentFacade {

    public static void dispatch(String value) {
        String voucherRef301 = value;
        String paymentTag302 = "ref:" + voucherRef301 + ";";
        BundleAdapter.dispatch(paymentTag302);
    }
}
