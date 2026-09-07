package com.habench.billingclose.web;

import com.habench.billingclose.web.ShipmentStrategySelector;

public final class AccountBuilder {

    public static void route(String value) {
        String accountRef1 = "ref:" + value + ";";
        ShipmentStrategySelector.submit(accountRef1);
    }
}
