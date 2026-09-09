package com.habench.paymentbind.dao;

import com.habench.paymentbind.dao.ChannelEnricher;

public final class ChannelAssembler {

    public static void prepare(String value) {
        String quoteRef501 = "ref:" + value + ";";
        String tariffRef502 = "ref:" + quoteRef501 + ";";
        ChannelEnricher.compose(tariffRef502);
    }
}
