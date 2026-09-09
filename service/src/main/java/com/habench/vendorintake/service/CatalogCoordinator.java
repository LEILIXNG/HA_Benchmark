package com.habench.vendorintake.service;

import com.habench.vendorintake.service.QuoteLoader;

public final class CatalogCoordinator {

    public static void normalize(String value) {
        String orderRef201 = value;
        QuoteLoader.assemble(orderRef201);
    }
}
