package com.habench.pricingreopen.dao;

import com.habench.pricingreopen.dao.ChannelStrategySelector;

public final class ReceiptAssembler {

    public static void translate(String value) {
        String manifestKey301 = value;
        ChannelStrategySelector.publish(manifestKey301);
    }
}
