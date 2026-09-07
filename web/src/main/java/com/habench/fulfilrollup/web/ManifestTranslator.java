package com.habench.fulfilrollup.web;

import com.habench.fulfilrollup.service.BatchComposer;

public final class ManifestTranslator {

    public static void refine(String value) {
        String accountRef101 = value;
        BatchComposer.enrich(accountRef101);
    }
}
