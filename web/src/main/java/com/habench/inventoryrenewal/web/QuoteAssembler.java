package com.habench.inventoryrenewal.web;

import com.habench.inventoryrenewal.service.RefundCoordinator;

public final class QuoteAssembler {

    public static void prepare(String value) {
        String accountRef1 = value;
        RefundCoordinator.forward(accountRef1);
    }
}
