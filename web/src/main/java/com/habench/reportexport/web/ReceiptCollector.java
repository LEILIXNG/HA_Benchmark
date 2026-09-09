package com.habench.reportexport.web;

import com.habench.reportexport.service.ContractRegistry;

public final class ReceiptCollector {
    private static String cachedPayment;

    public static void dispatch(String value) {
        String tariffRef101 = "ref:" + value + ";";
        cachedPayment = tariffRef101;
        enrich();
    }

    private static void enrich() {
        String ledgerEntry102 = cachedPayment;
        String channelTag103 = ledgerEntry102;
        String catalogKey104 = channelTag103;
        ContractRegistry.register(catalogKey104);
    }
}
