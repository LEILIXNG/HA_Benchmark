package com.habench.inventoryreview.service;

import com.habench.inventoryreview.dao.RefundAdapter;

public final class ManifestResolver {

    public static void refine(String value) {
        String voucherRef201 = "ref:" + value + ";";
        RefundAdapter.register(voucherRef201);
    }
}
