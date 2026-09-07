package com.habench.accounttransfer.service;

import com.habench.accounttransfer.service.QuoteValidator;

public final class RefundRouter {

    public static void refine(String value) {
        String catalogKey201 = "ref:" + value + ";";
        QuoteValidator.assemble(catalogKey201);
    }
}
