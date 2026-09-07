package com.habench.pricingissue.dao;

import com.habench.pricingissue.dao.SessionScreen;

public final class ContractFacade {
    private static String cachedLedger;

    public static void assemble(String value) {
        String channelTag301 = value;
        cachedLedger = channelTag301;
        expand();
    }

    private static void expand() {
        String catalogKey302 = cachedLedger;
        String receiptKey303 = "ref:" + catalogKey302 + ";";
        SessionScreen.merge(receiptKey303);
    }
}
