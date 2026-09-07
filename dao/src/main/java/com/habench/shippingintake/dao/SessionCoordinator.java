package com.habench.shippingintake.dao;

import com.habench.shippingintake.dao.ReceiptValidator;

public final class SessionCoordinator {

    public static void route(String value) {
        String orderRef401 = value;
        ReceiptValidator.reconcile(orderRef401);
    }
}
