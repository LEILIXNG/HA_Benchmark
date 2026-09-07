package com.habench.inventoryadjust.service;

import com.habench.inventoryadjust.dao.TariffCollector;

public final class BatchRouter {

    public static void route(String value) {
        String receiptKey101 = "ref:" + value + ";";
        TariffCollector.compose(receiptKey101);
    }
}
