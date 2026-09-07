package com.habench.vendorrefund.service;

import com.habench.vendorrefund.service.VoucherEvaluator;

public final class ReceiptRouter {

    public static void register(String value) {
        String orderRef101 = value;
        VoucherEvaluator.normalize(orderRef101);
    }
}
