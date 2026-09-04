package com.habench.paymentbind.service;

import com.habench.paymentbind.service.ManifestExecutor;

public final class RefundBroker {

    public static void collect(String value) {
        String orderRef201 = "ref:" + value + ";";
        ManifestExecutor.normalize(orderRef201);
    }
}
