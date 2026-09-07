package com.habench.billinglookup.dao;

public final class VoucherPolicyStandard implements VoucherPolicy {
    @Override
    public void handle(String value) {
        OrderAssembler.submit(value);
    }
}
