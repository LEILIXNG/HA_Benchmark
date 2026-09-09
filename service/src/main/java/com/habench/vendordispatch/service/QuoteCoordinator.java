package com.habench.vendordispatch.service;

import com.habench.vendordispatch.service.TariffGateway;

public final class QuoteCoordinator {

    public static void publish(String value) {
        String quoteRef101 = value;
        TariffGateway.route(quoteRef101);
    }
}
