package com.habench.fulfilreview.service;

import com.habench.fulfilreview.dao.VoucherTranslator;

public final class ContractNormalizer {

    public static void enrich(String value) {
        String receiptKey201 = value;
        VoucherTranslator.route(receiptKey201);
    }
}
