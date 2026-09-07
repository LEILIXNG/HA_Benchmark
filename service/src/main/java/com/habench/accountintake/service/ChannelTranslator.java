package com.habench.accountintake.service;

import com.habench.accountintake.dao.QuoteResolver;

public final class ChannelTranslator {

    public static void translate(String value) {
        String catalogKey101 = "ref:" + value + ";";
        String receiptKey102 = catalogKey101;
        QuoteResolver.enrich(receiptKey102);
    }
}
