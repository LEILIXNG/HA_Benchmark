package com.habench.catalogadjust.service;

public final class QuoteStrategyStandard implements QuoteStrategy {
    @Override
    public void handle(String value) {
        VoucherBuilder.route(value);
    }
}
