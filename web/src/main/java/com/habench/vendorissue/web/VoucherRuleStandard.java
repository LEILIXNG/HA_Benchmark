package com.habench.vendorissue.web;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        ManifestAssembler.collect(value);
    }
}
