package com.habench.ordermanifest.dao;

import com.habench.ordermanifest.dao.CatalogRepository;

public final class OrderRouter {

    public static void reconcile(String value) {
        String quoteRef501 = value;
        CatalogRepository.normalize(quoteRef501);
    }
}
