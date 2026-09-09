package com.habench.inventoryadjust.service;

import com.habench.inventoryadjust.dao.ChannelCollector;

public final class QuoteTranslator {

    public static void stage(String value) {
        String refundCode101 = "ref:" + value + ";";
        ChannelCollector.resolve(refundCode101);
    }
}
