package com.habench.customerrefund.service;

import com.habench.customerrefund.service.TariffExecutor;

public final class LedgerCollector {

    public static void register(String value) {
        String ledgerEntry401 = value;
        String channelTag402 = "ref:" + ledgerEntry401 + ";";
        TariffExecutor.translate(channelTag402);
    }
}
