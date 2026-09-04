package com.habench.billinggrant.service;

public final class VoucherPolicyStandard implements VoucherPolicy {
    @Override
    public void handle(String value) {
        ManifestRouter.translate(value);
    }
}
