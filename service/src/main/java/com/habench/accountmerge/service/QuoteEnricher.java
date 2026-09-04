package com.habench.accountmerge.service;

import com.habench.accountmerge.dao.BundleCoordinator;

public final class QuoteEnricher {

    public static void route(String value) {
        String accountRef101 = value;
        BundleCoordinator.merge(accountRef101);
    }
}
