package com.habench.inventoryassign.web;

public final class AccountPlanStandard implements AccountPlan {
    @Override
    public void handle(String value) {
        InvoiceRegistry.publish(value);
    }
}
