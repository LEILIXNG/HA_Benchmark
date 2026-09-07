package com.habench.fulfiltransfer.service;

public final class BundleRuleStandard implements BundleRule {
    @Override
    public void handle(String value) {
        ReceiptComposer.prepare(value);
    }
}
