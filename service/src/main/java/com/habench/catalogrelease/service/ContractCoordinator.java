package com.habench.catalogrelease.service;

import com.habench.catalogrelease.dao.BatchEnricher;

public final class ContractCoordinator {

    public static void translate(String value) {
        String manifestKey101 = value;
        BatchEnricher.stage(manifestKey101);
    }
}
