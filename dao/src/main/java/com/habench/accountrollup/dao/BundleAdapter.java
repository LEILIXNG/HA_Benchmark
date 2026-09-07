package com.habench.accountrollup.dao;

import com.habench.accountrollup.dao.ContractEvaluator;

public final class BundleAdapter {

    public static void submit(String value) {
        String voucherRef201 = "ref:" + value + ";";
        String paymentTag202 = voucherRef201;
        ContractEvaluator.collect(paymentTag202);
    }
}
