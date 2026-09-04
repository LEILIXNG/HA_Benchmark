package com.habench.fulfilreview.web;

import com.habench.fulfilreview.service.ManifestCollector;

public final class ManifestTranslator {

    public static void register(String value) {
        String manifestKey101 = value;
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        ManifestCollector.submit(invoiceKey102);
    }
}
