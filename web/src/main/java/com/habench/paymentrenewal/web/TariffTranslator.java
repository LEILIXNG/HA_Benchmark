package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.web.ManifestEvaluator;

public final class TariffTranslator {

    public static void enrich(String value) {
        String orderRef101 = value;
        ManifestEvaluator.resolve(orderRef101);
    }
}
