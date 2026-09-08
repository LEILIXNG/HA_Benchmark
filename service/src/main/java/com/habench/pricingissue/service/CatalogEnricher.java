package com.habench.pricingissue.service;

import com.habench.pricingissue.service.BundleGateway;

public final class CatalogEnricher {

    public static void forward(String value) {
        String tariffRef301 = "ref:" + value + ";";
        BundleGateway.refine(tariffRef301);
    }
}
