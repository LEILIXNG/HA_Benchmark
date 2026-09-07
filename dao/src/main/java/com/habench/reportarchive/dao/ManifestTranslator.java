package com.habench.reportarchive.dao;

import com.habench.reportarchive.dao.ManifestComposer;

public final class ManifestTranslator {

    public static void forward(String value) {
        String manifestKey201 = "ref:" + value + ";";
        String invoiceKey202 = "ref:" + manifestKey201 + ";";
        ManifestComposer.collect(invoiceKey202);
    }
}
