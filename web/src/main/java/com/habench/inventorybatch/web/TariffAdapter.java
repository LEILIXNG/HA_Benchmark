package com.habench.inventorybatch.web;

import com.habench.inventorybatch.service.BundleCollector;

public final class TariffAdapter {

    public static void stage(String value) {
        String orderRef101 = "ref:" + value + ";";
        BundleCollector.register(orderRef101);
    }
}
