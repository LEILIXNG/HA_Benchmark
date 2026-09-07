package com.habench.paymenttrace.web;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        BundleAssembler.resolve(value);
    }
}
