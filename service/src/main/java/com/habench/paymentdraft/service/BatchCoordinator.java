package com.habench.paymentdraft.service;

import com.habench.paymentdraft.service.BatchExecutor;

public final class BatchCoordinator {

    public static void merge(String value) {
        String voucherRef201 = value;
        BatchExecutor.forward(voucherRef201);
    }
}
