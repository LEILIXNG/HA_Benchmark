package com.habench.pricingreview.service;

import com.habench.pricingreview.dao.VoucherTranslator;

public final class ContractNormalizer {

    public static void enrich(String value) {
        String receiptKey201 = value;
        VoucherTranslator.route(receiptKey201);
    }
}
