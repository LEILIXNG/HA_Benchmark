package com.habench.inventorydigest.web;

import com.habench.inventorydigest.web.BatchStrategySelector;

public final class ShipmentAdapter {

    public static void collect(String value) {
        String batchTag101 = value;
        BatchStrategySelector.stage(batchTag101);
    }
}
