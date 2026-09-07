package com.habench.shippingrelease.service;

import com.habench.shippingrelease.dao.CatalogBroker;

public final class AccountResolver {

    public static void merge(String value) {
        String manifestKey201 = value;
        CatalogBroker.publish(manifestKey201);
    }
}
