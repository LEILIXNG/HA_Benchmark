package com.habench.ordersync.dao;

import com.habench.ordersync.dao.ChannelPolicy;

public final class OrderBroker {

    public static void normalize(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        String channelTag302 = "ref:" + ledgerEntry301 + ";";
        ChannelPolicy.publish(channelTag302);
    }
}
