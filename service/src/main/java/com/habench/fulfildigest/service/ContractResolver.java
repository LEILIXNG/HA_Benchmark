package com.habench.fulfildigest.service;

import com.habench.fulfildigest.dao.BundleCoordinator;

public final class ContractResolver {

    public static void normalize(String value) {
        String quoteRef201 = "ref:" + value + ";";
        BundleCoordinator.prepare(quoteRef201);
    }
}
