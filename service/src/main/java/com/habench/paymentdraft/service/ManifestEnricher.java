package com.habench.paymentdraft.service;

import com.habench.paymentdraft.dao.BatchCoordinator;

public final class ManifestEnricher {

    public static void merge(String value) {
        String voucherRef201 = "ref:" + value + ";";
        BatchCoordinator.enrich(voucherRef201);
    }
}
