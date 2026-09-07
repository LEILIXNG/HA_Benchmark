package com.habench.vendorarchive.dao;

import com.habench.vendorarchive.dao.QuoteComposer;

public final class InvoiceCollector {

    public static void attach(String value) {
        String receiptKey301 = value;
        String accountRef302 = "ref:" + receiptKey301 + ";";
        QuoteComposer.compose(accountRef302);
    }
}
