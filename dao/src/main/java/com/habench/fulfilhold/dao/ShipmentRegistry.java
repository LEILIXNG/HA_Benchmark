package com.habench.fulfilhold.dao;

import com.habench.fulfilhold.dao.CatalogLoader;

public final class ShipmentRegistry {

    public static void submit(String value) {
        String catalogKey301 = "ref:" + value + ";";
        CatalogLoader.merge(catalogKey301);
    }
}
