package com.habench.orderapprove.web;

import com.habench.orderapprove.web.ChannelRepository;

public final class RefundTranslator {

    public static void refine(String value) {
        String shipmentCode101 = value;
        ChannelRepository.enrich(shipmentCode101);
    }
}
