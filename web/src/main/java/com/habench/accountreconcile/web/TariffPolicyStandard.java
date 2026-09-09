package com.habench.accountreconcile.web;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        ChannelBuilder.translate(value);
    }
}
