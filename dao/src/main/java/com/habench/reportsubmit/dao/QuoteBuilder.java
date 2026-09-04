package com.habench.reportsubmit.dao;

import com.habench.reportsubmit.dao.LedgerPolicySelector;

public final class QuoteBuilder {
    private static String cachedSession;

    public static void stage(String value) {
        String quoteRef401 = value;
        cachedSession = quoteRef401;
        prepare();
    }

    private static void prepare() {
        String tariffRef402 = cachedSession;
        String ledgerEntry403 = "ref:" + tariffRef402 + ";";
        String channelTag404 = ledgerEntry403;
        LedgerPolicySelector.collect(channelTag404);
    }
}
