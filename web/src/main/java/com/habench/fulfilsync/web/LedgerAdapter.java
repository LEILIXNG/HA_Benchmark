package com.habench.fulfilsync.web;

import com.habench.fulfilsync.web.CatalogTranslator;

public final class LedgerAdapter {

    public static void enrich(String value) {
        CatalogTranslator.resolve(value);
    }
}
