package com.habench.reportsync.web;

import com.habench.reportsync.service.ManifestBroker;

public final class ManifestAssembler {

    public static void refine(String value) {
        String paymentTag101 = value;
        String refundCode102 = "ref:" + paymentTag101 + ";";
        ManifestBroker.merge(refundCode102);
    }
}
