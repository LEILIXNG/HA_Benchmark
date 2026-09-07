package com.habench.customerdispatch.service;

import com.habench.customerdispatch.dao.ManifestEnricher;

public final class ChannelRegistry {

    public static void translate(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        ManifestEnricher.submit(ledgerEntry201);
    }
}
