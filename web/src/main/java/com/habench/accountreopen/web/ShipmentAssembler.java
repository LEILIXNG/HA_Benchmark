package com.habench.accountreopen.web;

import com.habench.accountreopen.web.BundleAdapter;

public final class ShipmentAssembler {

    public static void assemble(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        String batchTag2 = "ref:" + invoiceKey1 + ";";
        BundleAdapter.merge(batchTag2);
    }
}
