package com.habench.inventorygrant.web;

import com.habench.inventorygrant.web.LedgerRepository;

public final class ReceiptFacade {

    public static void refine(String value) {
        String quoteRef101 = "ref:" + value + ";";
        LedgerRepository.refine(quoteRef101);
    }
}
