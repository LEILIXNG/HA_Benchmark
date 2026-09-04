package com.habench.shippingnotice.dao;

import com.habench.shippingnotice.dao.QuoteTranslator;

public final class AccountAdapter {

    public static void reconcile(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        QuoteTranslator.assemble(ledgerEntry201);
    }
}
