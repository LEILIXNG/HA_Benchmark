package com.habench.shippingrevise.web;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        ShipmentResolver.forward(value);
    }
}
