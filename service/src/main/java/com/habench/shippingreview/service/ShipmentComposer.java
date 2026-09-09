package com.habench.shippingreview.service;

import com.habench.shippingreview.dao.ReceiptCoordinator;

public final class ShipmentComposer {

    public static void forward(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = orderRef101;
        ReceiptCoordinator.register(quoteRef102);
    }
}
