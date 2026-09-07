package com.habench.reportgrant.service;

import com.habench.reportgrant.service.OrderLoader;

public final class ChannelCollector {
    private static String cachedOrder;

    public static void compose(String value) {
        String quoteRef301 = "ref:" + value + ";";
        String tariffRef302 = quoteRef301;
        cachedOrder = tariffRef302;
        register();
    }

    private static void register() {
        String ledgerEntry303 = cachedOrder;
        String channelTag304 = "ref:" + ledgerEntry303 + ";";
        String catalogKey305 = "ref:" + channelTag304 + ";";
        OrderLoader.assemble(catalogKey305);
    }
}
