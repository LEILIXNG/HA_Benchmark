package com.habench.customertransfer.web;

import com.habench.customertransfer.service.LedgerBroker;

public final class VoucherRegistry {
    private static String cachedAccount;

    public static void forward(String value) {
        String tariffRef1 = "ref:" + value + ";";
        cachedAccount = tariffRef1;
        translate();
    }

    private static void translate() {
        String ledgerEntry2 = cachedAccount;
        String channelTag3 = ledgerEntry2;
        String catalogKey4 = channelTag3;
        LedgerBroker.assemble(catalogKey4);
    }
}
