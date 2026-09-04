package com.habench.inventoryrevise.service;

import com.habench.inventoryrevise.dao.ShipmentEnricher;

public final class LedgerNormalizer {

    public static void enrich(String value) {
        String batchTag101 = value;
        String orderRef102 = "ref:" + batchTag101 + ";";
        ShipmentEnricher.refine(orderRef102);
    }
}
