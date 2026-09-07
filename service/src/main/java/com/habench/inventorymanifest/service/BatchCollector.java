package com.habench.inventorymanifest.service;

import com.habench.inventorymanifest.dao.TariffRegistry;

public final class BatchCollector {

    public static void translate(String value) {
        String channelTag301 = value;
        String catalogKey302 = channelTag301;
        TariffRegistry.dispatch(catalogKey302);
    }
}
