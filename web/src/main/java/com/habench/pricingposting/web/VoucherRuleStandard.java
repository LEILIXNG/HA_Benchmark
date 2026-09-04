package com.habench.pricingposting.web;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        ShipmentRouter.attach(value);
    }
}
