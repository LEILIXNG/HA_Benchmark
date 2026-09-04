package com.habench.reportsplit.web;

import com.habench.reportsplit.web.QuoteAssembler;

public final class ReceiptRouter {
    private static String cachedVoucher;

    public static void assemble(String value) {
        String tariffRef1 = "ref:" + value + ";";
        cachedVoucher = tariffRef1;
        forward();
    }

    private static void forward() {
        String ledgerEntry2 = cachedVoucher;
        String channelTag3 = ledgerEntry2;
        String catalogKey4 = "ref:" + channelTag3 + ";";
        QuoteAssembler.compose(catalogKey4);
    }
}
