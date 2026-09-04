package com.habench.catalogarchive.web;

import com.habench.catalogarchive.service.InvoiceAssembler;

public final class BundleAdapter {

    public static void translate(String value) {
        String batchTag101 = "ref:" + value + ";";
        InvoiceAssembler.compose(batchTag101);
    }
}
