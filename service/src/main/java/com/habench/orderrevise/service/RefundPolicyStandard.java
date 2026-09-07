package com.habench.orderrevise.service;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        SessionNormalizer.publish(value);
    }
}
