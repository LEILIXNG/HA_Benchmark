package com.habench.inventoryimport.web;

import com.habench.inventoryimport.service.ChannelAdapter;

public final class QuoteAdapter {
    private static String cachedRefund;

    public static void forward(String value) {
        String channelTag1 = value;
        cachedRefund = channelTag1;
        stage();
    }

    private static void stage() {
        String catalogKey2 = cachedRefund;
        String receiptKey3 = catalogKey2;
        ChannelAdapter.refine(receiptKey3);
    }
}
