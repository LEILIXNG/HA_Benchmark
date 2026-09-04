package com.habench.billingledger.service;

import com.habench.billingledger.service.BundleRepository;

public final class SessionBuilder {

    public static void enrich(String value) {
        String orderRef401 = "ref:" + value + ";";
        BundleRepository.route(orderRef401);
    }
}
