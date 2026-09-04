package com.habench.customercapture.web;

import com.habench.customercapture.service.ManifestRegistry;

public final class VoucherNormalizer {

    public static void publish(String value) {
        String paymentTag101 = "ref:" + value + ";";
        ManifestRegistry.forward(paymentTag101);
    }
}
