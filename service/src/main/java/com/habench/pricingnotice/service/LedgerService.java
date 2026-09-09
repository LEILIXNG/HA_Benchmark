package com.habench.pricingnotice.service;

import com.habench.pricingnotice.service.TariffValidator;

public final class LedgerService {

    public static void compose(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        String channelTag202 = ledgerEntry201;
        TariffValidator.assemble(channelTag202);
    }
}
