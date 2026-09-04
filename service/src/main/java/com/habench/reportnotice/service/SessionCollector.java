package com.habench.reportnotice.service;

import com.habench.reportnotice.dao.TariffComposer;

public final class SessionCollector {
    private static String cachedTariff;

    public static void collect(String value) {
        String catalogKey101 = "ref:" + value + ";";
        String receiptKey102 = catalogKey101;
        cachedTariff = receiptKey102;
        assemble();
    }

    private static void assemble() {
        String accountRef103 = cachedTariff;
        String voucherRef104 = accountRef103;
        TariffComposer.merge(voucherRef104);
    }
}
