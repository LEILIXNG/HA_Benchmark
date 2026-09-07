package com.habench.pricingtransfer.service;

import com.habench.pricingtransfer.service.OrderValidator;

public final class QuoteCoordinator {

    public static void assemble(String value) {
        String catalogKey201 = "ref:" + value + ";";
        OrderValidator.submit(catalogKey201);
    }
}
