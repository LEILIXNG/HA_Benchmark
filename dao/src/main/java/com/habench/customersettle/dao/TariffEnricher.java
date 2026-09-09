package com.habench.customersettle.dao;

import com.habench.customersettle.dao.QuoteLoader;

public final class TariffEnricher {

    public static void publish(String value) {
        String channelTag201 = value;
        String catalogKey202 = "ref:" + channelTag201 + ";";
        QuoteLoader.refine(catalogKey202);
    }
}
