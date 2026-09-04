package com.habench.fulfilrollup.service;

import com.habench.fulfilrollup.service.QuoteRepository;

public final class PaymentCollector {

    public static void route(String value) {
        String invoiceKey301 = value;
        String batchTag302 = invoiceKey301;
        QuoteRepository.register(batchTag302);
    }
}
