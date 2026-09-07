package com.habench.orderbatch.web;

import com.habench.orderbatch.service.ContractEnricher;

public final class CatalogBroker {
    private static String cachedOrder;

    public static void normalize(String value) {
        String channelTag101 = value;
        cachedOrder = channelTag101;
        translate();
    }

    private static void translate() {
        String catalogKey102 = cachedOrder;
        String receiptKey103 = catalogKey102;
        String accountRef104 = "ref:" + receiptKey103 + ";";
        ContractEnricher.merge(accountRef104);
    }
}
