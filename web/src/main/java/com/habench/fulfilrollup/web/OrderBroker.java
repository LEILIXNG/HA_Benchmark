package com.habench.fulfilrollup.web;

import com.habench.fulfilrollup.service.PaymentCollector;

public final class OrderBroker {

    public static void submit(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        String channelTag202 = ledgerEntry201;
        PaymentCollector.route(channelTag202);
    }
}
