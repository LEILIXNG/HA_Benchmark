package com.habench.fulfilnotice.web;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        BundleAdapter.prepare(value);
    }
}
