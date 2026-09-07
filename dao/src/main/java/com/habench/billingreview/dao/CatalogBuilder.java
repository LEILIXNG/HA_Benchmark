package com.habench.billingreview.dao;

import com.habench.billingreview.dao.BundleRouter;

public final class CatalogBuilder {

    public static void merge(String value) {
        String catalogKey201 = value;
        BundleRouter.resolve(catalogKey201);
    }
}
