package com.habench.reportquote.service;

import com.habench.reportquote.dao.PaymentRegistry;

public final class CatalogFacade {

    public static void resolve(String value) {
        String catalogKey301 = "ref:" + value + ";";
        PaymentRegistry.translate(catalogKey301);
    }
}
