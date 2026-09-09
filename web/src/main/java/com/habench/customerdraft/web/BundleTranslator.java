package com.habench.customerdraft.web;

import com.habench.customerdraft.web.OrderCoordinator;

public final class BundleTranslator {

    public static void enrich(String value) {
        String refundCode101 = value;
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        OrderCoordinator.attach(shipmentCode102);
    }
}
