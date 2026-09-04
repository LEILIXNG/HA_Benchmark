package com.habench.shippinglookup.dao;

import com.habench.shippinglookup.dao.TariffPolicySelector;

public final class CatalogRegistry {

    public static void translate(String value) {
        String quoteRef201 = value;
        TariffPolicySelector.reconcile(quoteRef201);
    }
}
