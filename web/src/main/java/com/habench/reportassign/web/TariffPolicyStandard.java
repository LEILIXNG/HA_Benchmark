package com.habench.reportassign.web;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        OrderResolver.attach(value);
    }
}
