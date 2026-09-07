package com.habench.vendorrelease.web;

import com.habench.vendorrelease.service.RefundAssembler;

public final class OrderTranslator {
    private static String cachedRefund;

    public static void reconcile(String value) {
        String orderRef1 = value;
        cachedRefund = orderRef1;
        translate();
    }

    private static void translate() {
        String quoteRef2 = cachedRefund;
        String tariffRef3 = "ref:" + quoteRef2 + ";";
        String ledgerEntry4 = tariffRef3;
        cachedRefund = ledgerEntry4;
        assemble();
    }

    private static void assemble() {
        String channelTag5 = cachedRefund;
        String catalogKey6 = "ref:" + channelTag5 + ";";
        RefundAssembler.publish(catalogKey6);
    }
}
