package com.northwind.customerassign.dao;

import org.springframework.stereotype.Repository;

/**
 * 客户的默认处理策略。
 */
@Repository("customerassignLedgerStrategyStandard")
public class LedgerStrategyStandard implements LedgerStrategy {
    private final ReceiptEnricher receiptEnricher;

    public LedgerStrategyStandard(ReceiptEnricher receiptEnricher) {
        this.receiptEnricher = receiptEnricher;
    }

    @Override
    public void handle(String value) {
        this.receiptEnricher.prepare(value);
    }
}
