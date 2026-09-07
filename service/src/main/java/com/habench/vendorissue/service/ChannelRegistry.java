package com.habench.vendorissue.service;

import com.habench.vendorissue.service.CatalogRouter;

public final class ChannelRegistry {

    public static void enrich(String value) {
        String catalogKey401 = "ref:" + value + ";";
        CatalogRouter.enrich(catalogKey401);
    }
}
