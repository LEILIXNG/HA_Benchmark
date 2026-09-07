package com.habench.accountimport.service;

import com.habench.accountimport.service.OrderScreen;

public final class ManifestCollector {
    private static String cachedContract;

    public static void normalize(String value) {
        String quoteRef201 = "ref:" + value + ";";
        String tariffRef202 = "ref:" + quoteRef201 + ";";
        cachedContract = tariffRef202;
        refine();
    }

    private static void refine() {
        String ledgerEntry203 = cachedContract;
        String channelTag204 = "ref:" + ledgerEntry203 + ";";
        String catalogKey205 = channelTag204;
        cachedContract = catalogKey205;
        assemble();
    }

    private static void assemble() {
        String receiptKey206 = cachedContract;
        String accountRef207 = receiptKey206;
        String voucherRef208 = "ref:" + accountRef207 + ";";
        OrderScreen.route(voucherRef208);
    }
}
