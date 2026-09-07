package com.habench.shippingrevise.service;

import com.habench.shippingrevise.dao.ChannelEnricher;

public final class ReceiptCollector {

    public static void attach(String value) {
        String ledgerEntry501 = value;
        String channelTag502 = "ref:" + ledgerEntry501 + ";";
        ChannelEnricher.assemble(channelTag502);
    }
}
