package com.habench.inventorygrant.dao;

import com.habench.inventorygrant.dao.OrderGateway;

public final class ContractCoordinator {

    public static void reconcile(String value) {
        String orderRef301 = "ref:" + value + ";";
        String quoteRef302 = "ref:" + orderRef301 + ";";
        OrderGateway.submit(quoteRef302);
    }
}
