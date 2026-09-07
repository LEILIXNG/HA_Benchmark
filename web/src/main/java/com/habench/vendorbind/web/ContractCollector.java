package com.habench.vendorbind.web;

import com.habench.vendorbind.service.BatchCoordinator;

public final class ContractCollector {

    public static void translate(String value) {
        String catalogKey1 = value;
        BatchCoordinator.translate(catalogKey1);
    }
}
