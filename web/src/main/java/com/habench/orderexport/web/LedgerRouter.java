package com.habench.orderexport.web;

import com.habench.orderexport.service.ChannelService;

public final class LedgerRouter {

    public static void submit(String value) {
        String paymentTag101 = "ref:" + value + ";";
        ChannelService.forward(paymentTag101);
    }
}
