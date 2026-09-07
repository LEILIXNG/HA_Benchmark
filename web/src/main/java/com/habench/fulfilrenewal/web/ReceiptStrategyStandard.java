package com.habench.fulfilrenewal.web;

public final class ReceiptStrategyStandard implements ReceiptStrategy {
    @Override
    public void handle(String value) {
        ContractService.forward(value);
    }
}
