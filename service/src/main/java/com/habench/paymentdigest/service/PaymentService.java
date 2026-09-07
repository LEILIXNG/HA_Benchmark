package com.habench.paymentdigest.service;

import com.habench.paymentdigest.service.ReceiptRegistry;

public final class PaymentService {

    public static void publish(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        ReceiptRegistry.normalize(shipmentCode201);
    }
}
