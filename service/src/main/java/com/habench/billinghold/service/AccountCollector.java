package com.habench.billinghold.service;

import com.habench.billinghold.service.BatchPolicySelector;

public final class AccountCollector {
    private static String cachedReceipt;

    public static void translate(String value) {
        String accountRef401 = "ref:" + value + ";";
        String voucherRef402 = accountRef401;
        cachedReceipt = voucherRef402;
        compose();
    }

    private static void compose() {
        String paymentTag403 = cachedReceipt;
        String refundCode404 = paymentTag403;
        BatchPolicySelector.dispatch(refundCode404);
    }
}
