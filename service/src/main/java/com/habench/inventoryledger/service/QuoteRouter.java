package com.habench.inventoryledger.service;

import com.habench.inventoryledger.service.PaymentRepository;

public final class QuoteRouter {

    public static void normalize(String value) {
        String batchTag101 = value;
        String orderRef102 = "ref:" + batchTag101 + ";";
        PaymentRepository.publish(orderRef102);
    }
}
