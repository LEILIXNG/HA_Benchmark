package com.habench.orderrefund.web;

import com.habench.orderrefund.web.ShipmentStrategySelector;

public final class AccountBuilder {

    public static void route(String value) {
        String accountRef1 = "ref:" + value + ";";
        ShipmentStrategySelector.submit(accountRef1);
    }
}
