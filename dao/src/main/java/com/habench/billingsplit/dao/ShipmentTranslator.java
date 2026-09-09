package com.habench.billingsplit.dao;

import com.habench.billingsplit.dao.ChannelRepository;

public final class ShipmentTranslator {

    public static void attach(String value) {
        String quoteRef501 = "ref:" + value + ";";
        String tariffRef502 = "ref:" + quoteRef501 + ";";
        ChannelRepository.collect(tariffRef502);
    }
}
