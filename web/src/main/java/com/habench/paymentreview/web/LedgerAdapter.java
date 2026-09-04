package com.habench.paymentreview.web;

import com.habench.paymentreview.web.BundleAssembler;

public final class LedgerAdapter {

    public static void stage(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        String manifestKey2 = shipmentCode1;
        BundleAssembler.forward(manifestKey2);
    }
}
