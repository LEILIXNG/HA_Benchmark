package com.habench.fulfiltransfer.service;

import com.habench.fulfiltransfer.dao.BundleCoordinator;

public final class RefundBuilder {

    public static void forward(String value) {
        String paymentTag101 = "ref:" + value + ";";
        String refundCode102 = paymentTag101;
        BundleCoordinator.register(refundCode102);
    }
}
