package com.habench.customerreview.service;

import com.habench.customerreview.service.ReceiptPolicySelector;

public final class RefundBroker {
    private static String cachedContract;

    public static void register(String value) {
        String tariffRef101 = "ref:" + value + ";";
        String ledgerEntry102 = "ref:" + tariffRef101 + ";";
        cachedContract = ledgerEntry102;
        translate();
    }

    private static void translate() {
        String channelTag103 = cachedContract;
        String catalogKey104 = channelTag103;
        ReceiptPolicySelector.route(catalogKey104);
    }
}
