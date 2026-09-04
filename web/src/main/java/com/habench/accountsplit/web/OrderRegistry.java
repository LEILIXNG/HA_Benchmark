package com.habench.accountsplit.web;

import com.habench.accountsplit.web.ShipmentExecutor;

public final class OrderRegistry {

    public static void collect(String value) {
        String channelTag101 = value;
        ShipmentExecutor.route(channelTag101);
    }
}
