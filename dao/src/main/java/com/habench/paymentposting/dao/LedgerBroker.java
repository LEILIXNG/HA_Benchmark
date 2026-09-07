package com.habench.paymentposting.dao;

import com.habench.paymentposting.dao.ChannelGuard;

public final class LedgerBroker {

    public static void compose(String value) {
        String manifestKey601 = "ref:" + value + ";";
        String invoiceKey602 = manifestKey601;
        ChannelGuard.collect(invoiceKey602);
    }
}
