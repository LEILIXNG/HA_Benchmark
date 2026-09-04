package com.habench.inventoryreview.dao;

public final class BundlePlanStandard implements BundlePlan {
    @Override
    public void handle(String value) {
        VoucherFacade.submit(value);
    }
}
