package com.habench.customerarchive.service;

public final class PaymentStrategyStandard implements PaymentStrategy {
    @Override
    public void handle(String value) {
        CatalogFacade.publish(value);
    }
}
