package com.habench.reportverify.service;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        QuoteAdapter.submit(value);
    }
}
