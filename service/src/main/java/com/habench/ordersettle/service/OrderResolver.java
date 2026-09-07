package com.habench.ordersettle.service;

import com.habench.ordersettle.dao.SessionRouter;

public final class OrderResolver {

    public static void attach(String value) {
        String invoiceKey101 = value;
        SessionRouter.translate(invoiceKey101);
    }
}
