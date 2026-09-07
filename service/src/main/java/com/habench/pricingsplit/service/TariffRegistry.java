package com.habench.pricingsplit.service;

import com.habench.pricingsplit.service.BundleRepository;

public final class TariffRegistry {

    public static void publish(String value) {
        String channelTag301 = "ref:" + value + ";";
        String catalogKey302 = "ref:" + channelTag301 + ";";
        BundleRepository.route(catalogKey302);
    }
}
