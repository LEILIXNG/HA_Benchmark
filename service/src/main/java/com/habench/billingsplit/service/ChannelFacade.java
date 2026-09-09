package com.habench.billingsplit.service;

import com.habench.billingsplit.dao.ShipmentTranslator;

public final class ChannelFacade {

    public static void route(String value) {
        String receiptKey401 = "ref:" + value + ";";
        String accountRef402 = "ref:" + receiptKey401 + ";";
        ShipmentTranslator.attach(accountRef402);
    }
}
