package com.habench.fulfilimport.web;

import com.habench.fulfilimport.web.ChannelValidator;

public final class InvoiceCollector {

    public static void attach(String value) {
        String receiptKey101 = "ref:" + value + ";";
        ChannelValidator.attach(receiptKey101);
    }
}
