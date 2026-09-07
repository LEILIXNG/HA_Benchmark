package com.habench.paymentsync.service;

import com.habench.paymentsync.service.RefundPolicy;

public final class LedgerAdapter {

    public static void stage(String value) {
        String shipmentCode101 = value;
        String manifestKey102 = "ref:" + shipmentCode101 + ";";
        RefundPolicy.stage(manifestKey102);
    }
}
