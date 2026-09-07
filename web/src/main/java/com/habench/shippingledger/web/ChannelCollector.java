package com.habench.shippingledger.web;

import com.habench.shippingledger.service.RefundService;

public final class ChannelCollector {

    public static void route(String value) {
        String receiptKey201 = value;
        RefundService.route(receiptKey201);
    }
}
