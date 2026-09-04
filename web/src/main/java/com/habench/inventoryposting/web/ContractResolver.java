package com.habench.inventoryposting.web;

import com.habench.inventoryposting.web.BatchPolicySelector;

public final class ContractResolver {
    private static String cachedContract;

    public static void publish(String value) {
        String batchTag1 = value;
        String orderRef2 = batchTag1;
        cachedContract = orderRef2;
        stage();
    }

    private static void stage() {
        String quoteRef3 = cachedContract;
        String tariffRef4 = quoteRef3;
        String ledgerEntry5 = tariffRef4;
        BatchPolicySelector.stage(ledgerEntry5);
    }
}
