package com.habench.reportsync.web;

import com.habench.reportsync.web.ManifestAssembler;

public final class InvoiceBroker {

    public static void publish(String value) {
        String batchTag1 = "ref:" + value + ";";
        ManifestAssembler.refine(batchTag1);
    }
}
