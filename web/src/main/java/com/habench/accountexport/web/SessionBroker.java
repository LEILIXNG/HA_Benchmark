package com.habench.accountexport.web;

import com.habench.accountexport.service.InvoiceAdapter;

public final class SessionBroker {

    public static void normalize(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        String channelTag2 = ledgerEntry1;
        InvoiceAdapter.resolve(channelTag2);
    }
}
