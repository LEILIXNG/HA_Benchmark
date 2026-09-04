package com.habench.vendorrelease.service;

import com.habench.vendorrelease.service.RefundRepository;

public final class CatalogService {

    public static void translate(String value) {
        String orderRef401 = value;
        String quoteRef402 = orderRef401;
        RefundRepository.dispatch(quoteRef402);
    }
}
