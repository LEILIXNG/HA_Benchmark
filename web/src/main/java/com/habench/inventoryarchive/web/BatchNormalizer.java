package com.habench.inventoryarchive.web;

import com.habench.inventoryarchive.service.RefundAssembler;

public final class BatchNormalizer {

    public static void submit(String value) {
        String voucherRef101 = value;
        RefundAssembler.reconcile(voucherRef101);
    }
}
