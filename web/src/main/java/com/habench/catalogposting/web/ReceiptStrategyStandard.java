package com.habench.catalogposting.web;

public final class ReceiptStrategyStandard implements ReceiptStrategy {
    @Override
    public void handle(String value) {
        LedgerService.route(value);
    }
}
