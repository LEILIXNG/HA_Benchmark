package com.habench.pricingtrace.web;

import com.habench.pricingtrace.web.OrderService;

public final class InvoiceBroker {

    public static void resolve(String value) {
        String channelTag1 = "ref:" + value + ";";
        OrderService.expand(channelTag1);
    }
}
