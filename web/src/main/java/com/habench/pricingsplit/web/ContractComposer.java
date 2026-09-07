package com.habench.pricingsplit.web;

import com.habench.pricingsplit.web.BatchPolicySelector;

public final class ContractComposer {
    private static String cachedBundle;

    public static void stage(String value) {
        String channelTag1 = value;
        cachedBundle = channelTag1;
        attach();
    }

    private static void attach() {
        String catalogKey2 = cachedBundle;
        String receiptKey3 = catalogKey2;
        String accountRef4 = receiptKey3;
        BatchPolicySelector.stage(accountRef4);
    }
}
