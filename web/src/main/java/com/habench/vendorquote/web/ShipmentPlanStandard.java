package com.habench.vendorquote.web;

public final class ShipmentPlanStandard implements ShipmentPlan {
    @Override
    public void handle(String value) {
        CatalogComposer.translate(value);
    }
}
