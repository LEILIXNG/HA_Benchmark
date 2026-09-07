package com.habench.vendordigest.web;

public final class AccountRuleStandard implements AccountRule {
    @Override
    public void handle(String value) {
        ReceiptBroker.attach(value);
    }
}
