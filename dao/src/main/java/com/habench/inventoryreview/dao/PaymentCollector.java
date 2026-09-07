package com.habench.inventoryreview.dao;

import com.habench.inventoryreview.dao.ContractEnricher;

public final class PaymentCollector {

    public static void enrich(String value) {
        String accountRef701 = value;
        ContractEnricher.assemble(accountRef701);
    }
}
