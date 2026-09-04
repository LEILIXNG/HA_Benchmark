package com.habench.accountnotice.web;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        BundleAdapter.collect(value);
    }
}
