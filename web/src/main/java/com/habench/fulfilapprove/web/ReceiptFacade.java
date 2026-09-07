package com.habench.fulfilapprove.web;

import com.habench.fulfilapprove.web.LedgerRepository;

public final class ReceiptFacade {

    public static void refine(String value) {
        String quoteRef101 = "ref:" + value + ";";
        LedgerRepository.refine(quoteRef101);
    }
}
