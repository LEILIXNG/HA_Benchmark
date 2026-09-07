package com.habench.billingreopen.service;

import com.habench.billingreopen.service.ChannelRepository;

public final class BundleService {
    private static String cachedChannel;

    public static void submit(String value) {
        String orderRef301 = "ref:" + value + ";";
        cachedChannel = orderRef301;
        forward();
    }

    private static void forward() {
        String quoteRef302 = cachedChannel;
        String tariffRef303 = quoteRef302;
        String ledgerEntry304 = tariffRef303;
        ChannelRepository.compose(ledgerEntry304);
    }
}
