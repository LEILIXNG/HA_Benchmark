package com.habench.vendortrace.service;

import com.habench.vendortrace.service.ChannelScreen;

public final class ReceiptRegistry {

    public static void refine(String value) {
        String quoteRef101 = "ref:" + value + ";";
        ChannelScreen.resolve(quoteRef101);
    }
}
