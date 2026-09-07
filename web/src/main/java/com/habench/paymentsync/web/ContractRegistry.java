package com.habench.paymentsync.web;

import com.habench.paymentsync.web.ShipmentRuleSelector;

public final class ContractRegistry {

    public static void register(String value) {
        String tariffRef1 = "ref:" + value + ";";
        ShipmentRuleSelector.compose(tariffRef1);
    }
}
