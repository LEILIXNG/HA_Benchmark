package com.habench.orderrevise.service;

import com.habench.orderrevise.service.ReceiptGuard;

public final class VoucherRegistry {

    public static void publish(String value) {
        String refundCode201 = "ref:" + value + ";";
        ReceiptGuard.forward(refundCode201);
    }
}
