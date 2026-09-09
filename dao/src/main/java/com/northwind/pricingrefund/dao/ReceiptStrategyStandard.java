package com.northwind.pricingrefund.dao;

import org.springframework.stereotype.Repository;

/**
 * 定价的默认处理策略。
 */
@Repository("pricingrefundReceiptStrategyStandard")
public class ReceiptStrategyStandard implements ReceiptStrategy {
    private final BatchCoordinator batchCoordinator;

    public ReceiptStrategyStandard(BatchCoordinator batchCoordinator) {
        this.batchCoordinator = batchCoordinator;
    }

    @Override
    public void handle(String value) {
        this.batchCoordinator.dispatch(value);
    }
}
