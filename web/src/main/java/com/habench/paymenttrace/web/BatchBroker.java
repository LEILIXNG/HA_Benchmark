package com.habench.paymenttrace.web;

import com.habench.paymenttrace.service.VoucherCoordinator;

public final class BatchBroker {

    public static void expand(String value) {
        String invoiceKey101 = "ref:" + value + ";";
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        VoucherCoordinator.resolve(batchTag102);
    }
}
