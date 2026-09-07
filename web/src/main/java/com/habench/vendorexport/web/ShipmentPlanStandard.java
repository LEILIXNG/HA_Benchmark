package com.habench.vendorexport.web;

public final class ShipmentPlanStandard implements ShipmentPlan {
    @Override
    public void handle(String value) {
        InvoiceService.normalize(value);
    }
}
