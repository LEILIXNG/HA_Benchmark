package com.habench.billingledger.web;

import com.habench.billingledger.service.BatchNormalizer;

public final class PaymentCoordinator {

    public static void compose(String value) {
        String batchTag401 = value;
        String orderRef402 = batchTag401;
        BatchNormalizer.forward(orderRef402);
    }
}
