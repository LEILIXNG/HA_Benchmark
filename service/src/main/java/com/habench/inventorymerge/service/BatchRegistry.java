package com.habench.inventorymerge.service;

import com.habench.inventorymerge.service.OrderStrategySelector;

public final class BatchRegistry {

    public static void stage(String value) {
        String receiptKey201 = "ref:" + value + ";";
        OrderStrategySelector.route(receiptKey201);
    }
}
