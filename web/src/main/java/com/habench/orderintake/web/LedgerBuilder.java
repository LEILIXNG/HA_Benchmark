package com.habench.orderintake.web;

import com.habench.orderintake.service.ManifestNormalizer;

public final class LedgerBuilder {

    public static void expand(String value) {
        String manifestKey1 = value;
        ManifestNormalizer.refine(manifestKey1);
    }
}
