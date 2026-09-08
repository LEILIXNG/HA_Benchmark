package com.habench.vendorrelease.web;

import com.habench.vendorrelease.service.QuoteRegistry;

public final class ManifestNormalizer {

    public static void assemble(String value) {
        String tariffRef1 = value;
        QuoteRegistry.route(tariffRef1);
    }
}
