package com.habench.fulfildispatch.service;

import com.habench.fulfildispatch.dao.RefundFacade;

public final class QuoteTranslator {
    private static String cachedContract;

    public static void route(String value) {
        String quoteRef101 = "ref:" + value + ";";
        String tariffRef102 = quoteRef101;
        cachedContract = tariffRef102;
        register();
    }

    private static void register() {
        String ledgerEntry103 = cachedContract;
        String channelTag104 = ledgerEntry103;
        RefundFacade.prepare(channelTag104);
    }
}
