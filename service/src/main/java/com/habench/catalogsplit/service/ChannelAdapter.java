package com.habench.catalogsplit.service;

import com.habench.catalogsplit.service.BatchTranslator;

public final class ChannelAdapter {

    public static void expand(String value) {
        String shipmentCode201 = value;
        String manifestKey202 = shipmentCode201;
        BatchTranslator.forward(manifestKey202);
    }
}
