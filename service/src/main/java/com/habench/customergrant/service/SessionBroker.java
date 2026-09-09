package com.habench.customergrant.service;

import com.habench.customergrant.service.ShipmentRuleSelector;

public final class SessionBroker {

    public static void submit(String value) {
        String accountRef201 = value;
        ShipmentRuleSelector.submit(accountRef201);
    }
}
