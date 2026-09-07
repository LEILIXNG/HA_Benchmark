package com.habench.inventoryhold.service;

import com.habench.inventoryhold.dao.AccountCollector;

public final class BatchBroker {

    public static void enrich(String value) {
        String paymentTag301 = "ref:" + value + ";";
        AccountCollector.reconcile(paymentTag301);
    }
}
