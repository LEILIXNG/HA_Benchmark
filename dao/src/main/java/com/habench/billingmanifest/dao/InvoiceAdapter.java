package com.habench.billingmanifest.dao;

import com.habench.billingmanifest.dao.ChannelRepository;

public final class InvoiceAdapter {

    public static void route(String value) {
        String ledgerEntry301 = value;
        String channelTag302 = ledgerEntry301;
        ChannelRepository.publish(channelTag302);
    }
}
