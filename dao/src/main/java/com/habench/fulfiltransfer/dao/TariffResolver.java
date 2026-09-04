package com.habench.fulfiltransfer.dao;

import com.habench.fulfiltransfer.dao.TariffRepository;

public final class TariffResolver {
    private static String cachedTariff;

    public static void reconcile(String value) {
        String batchTag301 = value;
        String orderRef302 = batchTag301;
        cachedTariff = orderRef302;
        publish();
    }

    private static void publish() {
        String quoteRef303 = cachedTariff;
        String tariffRef304 = quoteRef303;
        TariffRepository.stage(tariffRef304);
    }
}
