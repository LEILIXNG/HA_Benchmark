package com.habench.shippingclose.web;

import com.habench.shippingclose.web.CatalogTranslator;

public final class ChannelNormalizer {

    public static void prepare(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        String manifestKey102 = shipmentCode101;
        CatalogTranslator.collect(manifestKey102);
    }
}
