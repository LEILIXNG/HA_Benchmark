package com.habench.fulfilrelease.service;

import com.habench.fulfilrelease.service.PaymentGateway;

public final class SessionNormalizer {

    public static void collect(String value) {
        String refundCode101 = value;
        PaymentGateway.submit(refundCode101);
    }
}
