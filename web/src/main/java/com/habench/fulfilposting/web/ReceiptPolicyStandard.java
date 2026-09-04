package com.habench.fulfilposting.web;

public final class ReceiptPolicyStandard implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        BatchResolver.prepare(value);
    }
}
