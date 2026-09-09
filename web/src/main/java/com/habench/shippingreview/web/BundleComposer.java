package com.habench.shippingreview.web;

import com.habench.shippingreview.service.ShipmentComposer;

public final class BundleComposer {

    public static void register(String value) {
        String catalogKey1 = "ref:" + value + ";";
        ShipmentComposer.forward(catalogKey1);
    }
}
