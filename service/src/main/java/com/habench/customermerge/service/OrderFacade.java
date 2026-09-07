package com.habench.customermerge.service;

import com.habench.customermerge.dao.CatalogFacade;

public final class OrderFacade {

    public static void register(String value) {
        String manifestKey201 = value;
        CatalogFacade.collect(manifestKey201);
    }
}
