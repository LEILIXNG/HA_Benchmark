package com.habench.vendorrelease.web;

import com.habench.vendorrelease.service.CatalogService;

public final class ShipmentComposer {

    public static void stage(String value) {
        String catalogKey301 = "ref:" + value + ";";
        String receiptKey302 = "ref:" + catalogKey301 + ";";
        CatalogService.translate(receiptKey302);
    }
}
