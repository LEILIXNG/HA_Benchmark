package com.habench.fulfilrollup.web;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        OrderBroker.submit(value);
    }
}
