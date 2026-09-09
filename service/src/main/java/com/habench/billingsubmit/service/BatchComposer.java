package com.habench.billingsubmit.service;

import com.habench.billingsubmit.service.BatchFetcher;

public final class BatchComposer {
    private static String cachedBatch;

    public static void expand(String value) {
        String channelTag301 = value;
        cachedBatch = channelTag301;
        dispatch();
    }

    private static void dispatch() {
        String catalogKey302 = cachedBatch;
        String receiptKey303 = "ref:" + catalogKey302 + ";";
        BatchFetcher.expand(receiptKey303);
    }
}
