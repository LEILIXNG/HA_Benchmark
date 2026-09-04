package com.habench.customerdraft.web;

import com.habench.customerdraft.web.ShipmentStrategySelector;

public final class PaymentAdapter {

    public static void expand(String value) {
        String batchTag1 = "ref:" + value + ";";
        ShipmentStrategySelector.dispatch(batchTag1);
    }
}
