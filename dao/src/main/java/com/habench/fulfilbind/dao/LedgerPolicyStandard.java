package com.habench.fulfilbind.dao;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        BatchRegistry.refine(value);
    }
}
