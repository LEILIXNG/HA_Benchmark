package com.habench.reportrefund.service;

import com.habench.reportrefund.dao.LedgerRegistry;

public final class PaymentTranslator {
    private static String cachedTariff;

    public static void compose(String value) {
        String quoteRef301 = value;
        String tariffRef302 = "ref:" + quoteRef301 + ";";
        cachedTariff = tariffRef302;
        prepare();
    }

    private static void prepare() {
        String ledgerEntry303 = cachedTariff;
        String channelTag304 = ledgerEntry303;
        LedgerRegistry.submit(channelTag304);
    }
}
