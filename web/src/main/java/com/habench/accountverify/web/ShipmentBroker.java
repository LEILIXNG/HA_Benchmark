package com.habench.accountverify.web;

import com.habench.accountverify.web.BundleExecutor;

public final class ShipmentBroker {

    public static void normalize(String value) {
        String batchTag101 = "ref:" + value + ";";
        String orderRef102 = batchTag101;
        BundleExecutor.expand(orderRef102);
    }
}
