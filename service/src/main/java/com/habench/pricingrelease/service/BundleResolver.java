package com.habench.pricingrelease.service;

import com.habench.pricingrelease.service.QuoteRepository;

public final class BundleResolver {

    public static void route(String value) {
        String refundCode201 = value;
        QuoteRepository.forward(refundCode201);
    }
}
