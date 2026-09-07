package com.habench.reporttrace.service;

import com.habench.reporttrace.service.PaymentExecutor;

public final class ManifestRegistry {

    public static void publish(String value) {
        String manifestKey101 = value;
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        PaymentExecutor.assemble(invoiceKey102);
    }
}
