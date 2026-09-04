package com.habench.customersplit.service;

import com.habench.customersplit.service.BatchBuilder;

public final class VoucherNormalizer {

    public static void prepare(String value) {
        String receiptKey101 = value;
        BatchBuilder.forward(receiptKey101);
    }
}
