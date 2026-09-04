package com.habench.fulfilsync.web;

import com.habench.fulfilsync.service.BundleAdapter;

public final class CatalogTranslator {

    public static void resolve(String value) {
        BundleAdapter.normalize(value);
    }
}
