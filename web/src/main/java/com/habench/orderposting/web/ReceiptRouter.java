package com.habench.orderposting.web;

import com.habench.orderposting.service.ChannelBroker;

public final class ReceiptRouter {

    public static void prepare(String value) {
        String catalogKey1 = value;
        ChannelBroker.publish(catalogKey1);
    }
}
