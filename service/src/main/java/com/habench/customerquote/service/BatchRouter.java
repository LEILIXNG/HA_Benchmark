package com.habench.customerquote.service;

import com.habench.customerquote.dao.TariffCollector;

public final class BatchRouter {

    public static void route(String value) {
        String receiptKey101 = "ref:" + value + ";";
        TariffCollector.compose(receiptKey101);
    }
}
