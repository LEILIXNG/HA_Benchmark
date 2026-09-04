package com.habench.vendoradjust.service;

public final class TariffPolicyLegacy implements TariffPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
