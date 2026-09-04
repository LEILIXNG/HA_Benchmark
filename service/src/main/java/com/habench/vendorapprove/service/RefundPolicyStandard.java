package com.habench.vendorapprove.service;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        ContractService.submit(value);
    }
}
