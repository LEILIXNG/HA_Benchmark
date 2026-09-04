package com.habench.vendordispatch.service;

import com.habench.vendordispatch.service.TariffCollector;

public final class ManifestRouter {

    public static void dispatch(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        String channelTag102 = ledgerEntry101;
        TariffCollector.translate(channelTag102);
    }
}
