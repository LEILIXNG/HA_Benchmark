package com.habench.reportdispatch.service;

import com.habench.reportdispatch.dao.VoucherTranslator;

public final class ContractNormalizer {

    public static void enrich(String value) {
        String receiptKey201 = value;
        VoucherTranslator.route(receiptKey201);
    }
}
