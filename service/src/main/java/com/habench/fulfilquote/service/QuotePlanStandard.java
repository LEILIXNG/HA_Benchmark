package com.habench.fulfilquote.service;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        AccountAssembler.compose(value);
    }
}
