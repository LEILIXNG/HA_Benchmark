package com.habench.reportmerge.dao;

public final class InvoicePlanStandard implements InvoicePlan {
    @Override
    public void handle(String value) {
        ShipmentRouter.merge(value);
    }
}
