package com.habench.pricingsettlequeue.web;

public final class VoucherPolicyStandard implements VoucherPolicy {
    @Override
    public void handle(String value) {
        ManifestBuilder.register(value);
    }
}
