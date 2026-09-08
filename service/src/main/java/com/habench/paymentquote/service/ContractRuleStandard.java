package com.habench.paymentquote.service;

public final class ContractRuleStandard implements ContractRule {
    @Override
    public void handle(String value) {
        InvoiceResolver.assemble(value);
    }
}
