package com.habench.pricingledger.dao;

import com.habench.pricingledger.dao.BundleRepository;

public final class ManifestEnricher {

    public static void refine(String value) {
        String orderRef301 = value;
        BundleRepository.stage(orderRef301);
    }
}
