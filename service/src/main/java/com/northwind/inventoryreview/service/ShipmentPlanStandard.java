package com.northwind.inventoryreview.service;

/**
 * 库存的默认处理策略。
 */
public final class ShipmentPlanStandard implements ShipmentPlan {

    @Override
    public void handle(String value) {
        ManifestResolver.refine(value);
    }
}
