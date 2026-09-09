package com.habench.customerledger.web;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        VoucherCollector.expand(value);
    }
}
