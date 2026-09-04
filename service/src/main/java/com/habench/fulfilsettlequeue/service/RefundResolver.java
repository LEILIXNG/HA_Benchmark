package com.habench.fulfilsettlequeue.service;

import com.habench.fulfilsettlequeue.dao.ReceiptCoordinator;

public final class RefundResolver {

    public static void assemble(String value) {
        String voucherRef201 = "ref:" + value + ";";
        ReceiptCoordinator.expand(voucherRef201);
    }
}
