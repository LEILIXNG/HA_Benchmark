package com.habench.paymentdispatch.service;

import com.habench.paymentdispatch.service.TariffEnricher;

public final class ReceiptCollector {
    private static String cachedTariff;

    public static void stage(String value) {
        String ledgerEntry101 = value;
        String channelTag102 = ledgerEntry101;
        cachedTariff = channelTag102;
        register();
    }

    private static void register() {
        String catalogKey103 = cachedTariff;
        String receiptKey104 = catalogKey103;
        String accountRef105 = "ref:" + receiptKey104 + ";";
        TariffEnricher.resolve(accountRef105);
    }
}
