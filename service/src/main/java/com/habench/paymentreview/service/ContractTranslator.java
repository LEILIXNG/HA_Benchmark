package com.habench.paymentreview.service;

import com.habench.paymentreview.dao.QuoteCoordinator;

public final class ContractTranslator {

    public static void expand(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        QuoteCoordinator.resolve(ledgerEntry101);
    }
}
