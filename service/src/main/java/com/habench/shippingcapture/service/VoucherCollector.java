package com.habench.shippingcapture.service;

import com.habench.shippingcapture.dao.ReceiptRegistry;

public final class VoucherCollector {

    public static void attach(String value) {
        String manifestKey301 = "ref:" + value + ";";
        ReceiptRegistry.enrich(manifestKey301);
    }
}
