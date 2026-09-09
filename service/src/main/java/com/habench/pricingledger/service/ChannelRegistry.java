package com.habench.pricingledger.service;

import com.habench.pricingledger.dao.ManifestEnricher;

public final class ChannelRegistry {

    public static void translate(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        ManifestEnricher.submit(ledgerEntry201);
    }
}
