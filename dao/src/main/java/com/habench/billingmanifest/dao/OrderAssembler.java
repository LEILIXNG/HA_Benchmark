package com.habench.billingmanifest.dao;

import com.habench.billingmanifest.dao.BatchPolicySelector;

public final class OrderAssembler {

    public static void refine(String value) {
        String invoiceKey401 = value;
        String batchTag402 = invoiceKey401;
        BatchPolicySelector.submit(batchTag402);
    }
}
