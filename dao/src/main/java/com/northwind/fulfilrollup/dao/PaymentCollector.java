package com.northwind.fulfilrollup.dao;

import org.springframework.stereotype.Repository;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("fulfilrollupPaymentCollector")
public class PaymentCollector {
    private final QuoteRepository quoteRepository;

    public PaymentCollector(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public void route(String value) {
        String accountRef401 = String.format("ref:%s;", value);
        this.quoteRepository.register(accountRef401);
    }
}
