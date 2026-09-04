package com.habench.reportapprove.service;

public final class BatchStrategyStandard implements BatchStrategy {
    @Override
    public void handle(String value) {
        ContractAssembler.forward(value);
    }
}
