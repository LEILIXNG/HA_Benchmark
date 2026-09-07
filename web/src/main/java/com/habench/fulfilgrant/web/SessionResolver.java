package com.habench.fulfilgrant.web;

import com.habench.fulfilgrant.web.ChannelExecutor;

public final class SessionResolver {
    private static String cachedChannel;

    public static void normalize(String value) {
        String channelTag101 = "ref:" + value + ";";
        cachedChannel = channelTag101;
        merge();
    }

    private static void merge() {
        String catalogKey102 = cachedChannel;
        String receiptKey103 = "ref:" + catalogKey102 + ";";
        cachedChannel = receiptKey103;
        collect();
    }

    private static void collect() {
        String accountRef104 = cachedChannel;
        String voucherRef105 = accountRef104;
        ChannelExecutor.translate(voucherRef105);
    }
}
