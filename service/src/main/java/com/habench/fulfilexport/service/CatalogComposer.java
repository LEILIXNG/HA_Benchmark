package com.habench.fulfilexport.service;

import com.habench.fulfilexport.service.BundleLoader;

public final class CatalogComposer {

    public static void refine(String value) {
        String shipmentCode301 = value;
        BundleLoader.reconcile(shipmentCode301);
    }
}
