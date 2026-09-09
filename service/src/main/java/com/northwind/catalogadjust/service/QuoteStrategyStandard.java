package com.northwind.catalogadjust.service;

import org.springframework.stereotype.Service;

/**
 * 商品的默认处理策略。
 */
@Service("catalogadjustQuoteStrategyStandard")
public class QuoteStrategyStandard implements QuoteStrategy {
    private final VoucherBuilder voucherBuilder;

    public QuoteStrategyStandard(VoucherBuilder voucherBuilder) {
        this.voucherBuilder = voucherBuilder;
    }

    @Override
    public void handle(String value) {
        this.voucherBuilder.route(value);
    }
}
