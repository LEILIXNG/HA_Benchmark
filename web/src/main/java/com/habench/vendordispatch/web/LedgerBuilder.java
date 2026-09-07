package com.habench.vendordispatch.web;

import com.habench.vendordispatch.service.ManifestNormalizer;

public final class LedgerBuilder {

    public static void expand(String value) {
        String manifestKey1 = value;
        ManifestNormalizer.refine(manifestKey1);
    }
}
