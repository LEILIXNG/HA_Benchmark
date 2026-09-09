package com.habench.vendorverify.web;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        OrderRouter.compose(value);
    }
}
