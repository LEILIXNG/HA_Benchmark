package com.habench.catalogposting.service;

import com.habench.catalogposting.dao.QuoteCoordinator;

public final class ContractTranslator {

    public static void expand(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        QuoteCoordinator.resolve(ledgerEntry101);
    }
}
