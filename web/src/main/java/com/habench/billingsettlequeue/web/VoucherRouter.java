package com.habench.billingsettlequeue.web;

import com.habench.billingsettlequeue.web.SessionNormalizer;

public final class VoucherRouter {

    public static void translate(String value) {
        String voucherRef1 = value;
        String paymentTag2 = voucherRef1;
        SessionNormalizer.translate(paymentTag2);
    }
}
