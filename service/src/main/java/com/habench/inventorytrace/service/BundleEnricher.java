package com.habench.inventorytrace.service;

import com.habench.inventorytrace.service.ReceiptNormalizer;

public final class BundleEnricher {

    public static void stage(String value) {
        String refundCode101 = "ref:" + value + ";";
        ReceiptNormalizer.translate(refundCode101);
    }
}
