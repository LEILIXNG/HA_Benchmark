package com.habench.billingsplit.web;

import com.habench.billingsplit.web.ChannelStrategySelector;

public final class BatchBuilder {

    public static void normalize(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        String manifestKey2 = "ref:" + shipmentCode1 + ";";
        ChannelStrategySelector.resolve(manifestKey2);
    }
}
