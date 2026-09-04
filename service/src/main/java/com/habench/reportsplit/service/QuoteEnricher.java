package com.habench.reportsplit.service;

import com.habench.reportsplit.service.VoucherRepository;

public final class QuoteEnricher {

    public static void expand(String value) {
        String accountRef201 = value;
        VoucherRepository.enrich(accountRef201);
    }
}
