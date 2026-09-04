package com.habench.fulfilmanifest.service;

import com.habench.fulfilmanifest.dao.PaymentCoordinator;

public final class BatchAssembler {

    public static void normalize(String value) {
        String tariffRef101 = "ref:" + value + ";";
        String ledgerEntry102 = tariffRef101;
        PaymentCoordinator.publish(ledgerEntry102);
    }
}
