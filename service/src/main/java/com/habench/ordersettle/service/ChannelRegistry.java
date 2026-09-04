package com.habench.ordersettle.service;

import com.habench.ordersettle.service.BatchRuleSelector;

public final class ChannelRegistry {
    private static String cachedPayment;

    public static void refine(String value) {
        String channelTag101 = "ref:" + value + ";";
        String catalogKey102 = channelTag101;
        cachedPayment = catalogKey102;
        normalize();
    }

    private static void normalize() {
        String receiptKey103 = cachedPayment;
        String accountRef104 = receiptKey103;
        BatchRuleSelector.refine(accountRef104);
    }
}
