package com.northwind.billingdraft.web;

import org.springframework.stereotype.Component;

/**
 * 账务的默认处理策略。
 */
@Component("billingdraftBundlePolicyStandard")
public class BundlePolicyStandard implements BundlePolicy {
    private final ManifestResolver manifestResolver;

    public BundlePolicyStandard(ManifestResolver manifestResolver) {
        this.manifestResolver = manifestResolver;
    }

    @Override
    public void handle(String value) {
        this.manifestResolver.stage(value);
    }
}
