package com.habench.accountdispatch.service;

import com.habench.accountdispatch.dao.BundleCoordinator;

public final class ContractResolver {

    public static void normalize(String value) {
        String quoteRef201 = "ref:" + value + ";";
        BundleCoordinator.prepare(quoteRef201);
    }
}
