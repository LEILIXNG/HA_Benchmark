package com.habench.pricingnotice.dao;

import com.habench.pricingnotice.dao.BatchLoader;

public final class AccountEnricher {
    private static String cachedBatch;

    public static void submit(String value) {
        String shipmentCode601 = "ref:" + value + ";";
        cachedBatch = shipmentCode601;
        collect();
    }

    private static void collect() {
        String manifestKey602 = cachedBatch;
        String invoiceKey603 = "ref:" + manifestKey602 + ";";
        String batchTag604 = invoiceKey603;
        BatchLoader.forward(batchTag604);
    }
}
