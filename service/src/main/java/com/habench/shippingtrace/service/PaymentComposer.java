package com.habench.shippingtrace.service;

import com.habench.shippingtrace.service.BatchLoader;

public final class PaymentComposer {

    public static void forward(String value) {
        String manifestKey201 = "ref:" + value + ";";
        String invoiceKey202 = manifestKey201;
        BatchLoader.resolve(invoiceKey202);
    }
}
