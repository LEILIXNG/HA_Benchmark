package com.habench.fulfilrollup.dao;

import com.habench.fulfilrollup.dao.QuoteRepository;

public final class PaymentCollector {

    public static void route(String value) {
        String accountRef401 = "ref:" + value + ";";
        QuoteRepository.register(accountRef401);
    }
}
