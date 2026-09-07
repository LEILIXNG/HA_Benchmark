package com.habench.paymentdraft.web;

import com.habench.paymentdraft.service.LedgerService;

public final class LedgerTranslator {

    public static void submit(String value) {
        String ledgerEntry1 = value;
        String channelTag2 = ledgerEntry1;
        LedgerService.enrich(channelTag2);
    }
}
