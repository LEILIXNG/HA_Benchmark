package com.habench.vendorrevise.dao;

public final class AccountStrategyStandard implements AccountStrategy {
    @Override
    public void handle(String value) {
        BundleBuilder.route(value);
    }
}
