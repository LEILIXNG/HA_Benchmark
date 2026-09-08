package com.habench.pricingcapture.web;

import com.habench.pricingcapture.service.ManifestEnricher;

public final class CatalogNormalizer {

    public static void stage(String value) {
        String accountRef101 = value;
        ManifestEnricher.attach(accountRef101);
    }
}
