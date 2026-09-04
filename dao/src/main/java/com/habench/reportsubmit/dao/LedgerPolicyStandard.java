package com.habench.reportsubmit.dao;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        ManifestRouter.collect(value);
    }
}
