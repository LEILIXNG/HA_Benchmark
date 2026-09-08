package com.habench.pricingissue.service;

import com.habench.pricingissue.service.LedgerStrategySelector;

public final class CatalogFacade {

    public static void publish(String value) {
        String accountRef201 = "ref:" + value + ";";
        String voucherRef202 = accountRef201;
        LedgerStrategySelector.attach(voucherRef202);
    }
}
