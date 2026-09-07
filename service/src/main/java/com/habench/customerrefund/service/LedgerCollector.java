package com.habench.customerrefund.service;

import com.habench.customerrefund.service.TariffExecutor;

public final class LedgerCollector {
    private static String cachedTariff;

    public static void register(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        cachedTariff = batchTag202;
        refine();
    }

    private static void refine() {
        String orderRef203 = cachedTariff;
        String quoteRef204 = "ref:" + orderRef203 + ";";
        String tariffRef205 = quoteRef204;
        cachedTariff = tariffRef205;
        forward();
    }

    private static void forward() {
        String ledgerEntry206 = cachedTariff;
        String channelTag207 = ledgerEntry206;
        String catalogKey208 = "ref:" + channelTag207 + ";";
        TariffExecutor.translate(catalogKey208);
    }
}
