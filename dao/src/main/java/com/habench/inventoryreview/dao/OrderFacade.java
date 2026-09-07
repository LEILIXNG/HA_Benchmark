package com.habench.inventoryreview.dao;

import com.habench.inventoryreview.dao.RefundCoordinator;

public final class OrderFacade {

    public static void enrich(String value) {
        String accountRef401 = value;
        RefundCoordinator.merge(accountRef401);
    }
}
