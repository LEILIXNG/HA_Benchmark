package com.habench.fulfilsettle.service;

import com.habench.fulfilsettle.dao.RefundCoordinator;

public final class VoucherCollector {

    public static void enrich(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        RefundCoordinator.forward(ledgerEntry201);
    }
}
