package com.habench.shippinggrant.dao;

import com.habench.shippinggrant.dao.CatalogRepository;

public final class OrderRouter {

    public static void reconcile(String value) {
        String quoteRef501 = value;
        CatalogRepository.normalize(quoteRef501);
    }
}
