package com.habench.catalogimport.web;

import com.habench.catalogimport.web.CatalogResolver;

public final class ChannelTranslator {

    public static void normalize(String value) {
        String receiptKey1 = "ref:" + value + ";";
        CatalogResolver.stage(receiptKey1);
    }
}
