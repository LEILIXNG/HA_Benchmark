package com.habench.paymentrevise.service;

public final class TariffRuleStandard implements TariffRule {
    @Override
    public void handle(String value) {
        ShipmentAdapter.forward(value);
    }
}
