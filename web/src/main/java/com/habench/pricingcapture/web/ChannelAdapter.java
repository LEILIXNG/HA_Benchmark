package com.habench.pricingcapture.web;

import com.habench.pricingcapture.service.OrderService;

public final class ChannelAdapter {

    public static void expand(String value) {
        String manifestKey1 = "ref:" + value + ";";
        OrderService.prepare(manifestKey1);
    }
}
