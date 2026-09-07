package com.habench.billingdraft.web;

public final class BundlePolicyStandard implements BundlePolicy {
    @Override
    public void handle(String value) {
        ManifestResolver.stage(value);
    }
}
