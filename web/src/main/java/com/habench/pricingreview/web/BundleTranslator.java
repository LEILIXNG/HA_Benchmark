package com.habench.pricingreview.web;

import com.habench.pricingreview.web.OrderTranslator;

public final class BundleTranslator {

    public static void submit(String value) {
        String shipmentCode101 = value;
        OrderTranslator.publish(shipmentCode101);
    }
}
