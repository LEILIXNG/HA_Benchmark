package com.habench.pricinggrant.web;

import com.habench.pricinggrant.service.VoucherBroker;

public final class ChannelCollector {

    public static void publish(String value) {
        String catalogKey101 = "ref:" + value + ";";
        String receiptKey102 = "ref:" + catalogKey101 + ";";
        VoucherBroker.enrich(receiptKey102);
    }
}
