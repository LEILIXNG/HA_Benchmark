package com.habench.customerexport.service;

public final class SessionPolicyStandard implements SessionPolicy {
    @Override
    public void handle(String value) {
        ContractAssembler.publish(value);
    }
}
