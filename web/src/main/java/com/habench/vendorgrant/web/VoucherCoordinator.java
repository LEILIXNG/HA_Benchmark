package com.habench.vendorgrant.web;

import com.habench.vendorgrant.service.VoucherNormalizer;

public final class VoucherCoordinator {

    public static void attach(String value) {
        String orderRef1 = "ref:" + value + ";";
        VoucherNormalizer.reconcile(orderRef1);
    }
}
