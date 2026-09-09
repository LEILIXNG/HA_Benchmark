package com.northwind.catalogposting.web;

import org.springframework.stereotype.Component;

/**
 * 商品的默认处理策略。
 */
@Component("catalogpostingReceiptStrategyStandard")
public class ReceiptStrategyStandard implements ReceiptStrategy {
    private final LedgerService ledgerService;

    public ReceiptStrategyStandard(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    @Override
    public void handle(String value) {
        this.ledgerService.route(value);
    }
}
