package com.habench.shippingverify.web;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        ContractBroker.compose(value);
    }
}
