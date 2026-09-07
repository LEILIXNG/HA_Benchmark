package com.habench.customerquote.web;

import com.habench.customerquote.web.OrderCoordinator;

public final class BundleTranslator {

    public static void enrich(String value) {
        String refundCode101 = value;
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        OrderCoordinator.attach(shipmentCode102);
    }
}
