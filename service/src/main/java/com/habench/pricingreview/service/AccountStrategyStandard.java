package com.habench.pricingreview.service;

public final class AccountStrategyStandard implements AccountStrategy {
    @Override
    public void handle(String value) {
        PaymentResolver.translate(value);
    }
}
