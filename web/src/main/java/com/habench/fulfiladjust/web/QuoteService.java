package com.habench.fulfiladjust.web;

import com.habench.fulfiladjust.service.CatalogTranslator;

public final class QuoteService {

    public static void merge(String value) {
        String receiptKey101 = "ref:" + value + ";";
        CatalogTranslator.dispatch(receiptKey101);
    }
}
