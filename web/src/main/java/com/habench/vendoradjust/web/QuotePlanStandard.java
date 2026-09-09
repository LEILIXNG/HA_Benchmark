package com.habench.vendoradjust.web;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        ChannelEnricher.prepare(value);
    }
}
