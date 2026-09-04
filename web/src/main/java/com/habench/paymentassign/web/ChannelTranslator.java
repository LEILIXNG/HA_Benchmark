package com.habench.paymentassign.web;

import com.habench.paymentassign.service.AccountCollector;

public final class ChannelTranslator {

    public static void enrich(String value) {
        String orderRef101 = "ref:" + value + ";";
        AccountCollector.stage(orderRef101);
    }
}
