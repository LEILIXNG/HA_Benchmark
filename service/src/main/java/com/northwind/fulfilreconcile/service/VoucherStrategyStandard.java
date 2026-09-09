package com.northwind.fulfilreconcile.service;

import org.springframework.stereotype.Service;

/**
 * 履约的默认处理策略。
 */
@Service("fulfilreconcileVoucherStrategyStandard")
public class VoucherStrategyStandard implements VoucherStrategy {
    private final TariffBuilder tariffBuilder;

    public VoucherStrategyStandard(TariffBuilder tariffBuilder) {
        this.tariffBuilder = tariffBuilder;
    }

    @Override
    public void handle(String value) {
        this.tariffBuilder.expand(value);
    }
}
