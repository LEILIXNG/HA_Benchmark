package com.habench.inventoryimport.dao;

import com.habench.inventoryimport.dao.RefundLoader;

public final class ReceiptNormalizer {

    public static void prepare(String value) {
        String paymentTag201 = value;
        RefundLoader.enrich(paymentTag201);
    }
}
