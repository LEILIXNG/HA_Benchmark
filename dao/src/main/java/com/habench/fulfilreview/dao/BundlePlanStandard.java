package com.habench.fulfilreview.dao;

public final class BundlePlanStandard implements BundlePlan {
    @Override
    public void handle(String value) {
        OrderTranslator.submit(value);
    }
}
