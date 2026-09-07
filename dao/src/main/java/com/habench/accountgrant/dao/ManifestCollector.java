package com.habench.accountgrant.dao;

import com.habench.accountgrant.dao.TariffRepository;

public final class ManifestCollector {

    public static void compose(String value) {
        String channelTag401 = value;
        TariffRepository.enrich(channelTag401);
    }
}
