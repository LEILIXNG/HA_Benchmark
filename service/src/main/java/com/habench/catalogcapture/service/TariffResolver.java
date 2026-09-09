package com.habench.catalogcapture.service;

import com.habench.catalogcapture.service.TariffRuleSelector;

public final class TariffResolver {

    public static void publish(String value) {
        String accountRef101 = "ref:" + value + ";";
        TariffRuleSelector.attach(accountRef101);
    }
}
