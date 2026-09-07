package com.habench.billingreopen.web;

import com.habench.billingreopen.web.InvoiceEnricher;

public final class VoucherCoordinator {
    private static String cachedChannel;

    public static void enrich(String value) {
        String orderRef1 = "ref:" + value + ";";
        cachedChannel = orderRef1;
        stage();
    }

    private static void stage() {
        String quoteRef2 = cachedChannel;
        String tariffRef3 = quoteRef2;
        cachedChannel = tariffRef3;
        assemble();
    }

    private static void assemble() {
        String ledgerEntry4 = cachedChannel;
        String channelTag5 = ledgerEntry4;
        String catalogKey6 = channelTag5;
        InvoiceEnricher.refine(catalogKey6);
    }
}
