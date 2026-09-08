package com.habench.pricingreview.service;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        ReceiptAssembler.route(value);
    }
}
