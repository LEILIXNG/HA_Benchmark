package com.habench.vendorbind.web;

import com.habench.vendorbind.service.BatchTranslator;

public final class RefundCollector {

    public static void translate(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = orderRef101;
        BatchTranslator.assemble(quoteRef102);
    }
}
