package com.habench.fulfiladjust.service;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        OrderResolver.refine(value);
    }
}
