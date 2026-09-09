package com.habench.shippinghold.web;

import com.habench.shippinghold.web.LedgerRepository;

public final class ReceiptFacade {

    public static void refine(String value) {
        String quoteRef101 = "ref:" + value + ";";
        LedgerRepository.refine(quoteRef101);
    }
}
