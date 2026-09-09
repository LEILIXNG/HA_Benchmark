package com.northwind.shippingdispatch.dao;

import org.springframework.stereotype.Repository;

/**
 * 发运的默认处理策略。
 */
@Repository("shippingdispatchBatchStrategyStandard")
public class BatchStrategyStandard implements BatchStrategy {
    private final LedgerResolver ledgerResolver;

    public BatchStrategyStandard(LedgerResolver ledgerResolver) {
        this.ledgerResolver = ledgerResolver;
    }

    @Override
    public void handle(String value) {
        this.ledgerResolver.route(value);
    }
}
