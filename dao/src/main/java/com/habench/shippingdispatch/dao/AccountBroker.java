package com.habench.shippingdispatch.dao;

import com.habench.shippingdispatch.dao.BatchStrategySelector;

public final class AccountBroker {

    public static void translate(String value) {
        String manifestKey301 = "ref:" + value + ";";
        BatchStrategySelector.normalize(manifestKey301);
    }
}
