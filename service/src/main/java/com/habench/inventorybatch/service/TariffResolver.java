package com.habench.inventorybatch.service;

import com.habench.inventorybatch.service.TariffRuleSelector;

public final class TariffResolver {

    public static void publish(String value) {
        String accountRef101 = "ref:" + value + ";";
        TariffRuleSelector.attach(accountRef101);
    }
}
