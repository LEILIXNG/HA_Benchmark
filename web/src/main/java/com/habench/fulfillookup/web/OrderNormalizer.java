package com.habench.fulfillookup.web;

import com.habench.fulfillookup.web.ContractRuleSelector;

public final class OrderNormalizer {
    private static String cachedPayment;

    public static void enrich(String value) {
        String channelTag1 = "ref:" + value + ";";
        String catalogKey2 = channelTag1;
        cachedPayment = catalogKey2;
        collect();
    }

    private static void collect() {
        String receiptKey3 = cachedPayment;
        String accountRef4 = "ref:" + receiptKey3 + ";";
        String voucherRef5 = "ref:" + accountRef4 + ";";
        ContractRuleSelector.prepare(voucherRef5);
    }
}
