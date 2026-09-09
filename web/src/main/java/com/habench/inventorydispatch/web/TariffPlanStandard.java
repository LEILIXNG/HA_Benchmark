package com.habench.inventorydispatch.web;

public final class TariffPlanStandard implements TariffPlan {
    @Override
    public void handle(String value) {
        InvoiceAssembler.register(value);
    }
}
