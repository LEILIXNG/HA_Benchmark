package com.habench.catalogtrace.web;

import com.habench.catalogtrace.service.ManifestNormalizer;

public final class LedgerComposer {

    public static void forward(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        ManifestNormalizer.enrich(ledgerEntry1);
    }
}
