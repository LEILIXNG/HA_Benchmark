package com.habench.billingdispatch.dao;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        ReceiptTranslator.resolve(value);
    }
}
