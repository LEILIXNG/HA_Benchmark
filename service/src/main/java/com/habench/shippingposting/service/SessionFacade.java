package com.habench.shippingposting.service;

import com.habench.shippingposting.dao.BundleCoordinator;

public final class SessionFacade {

    public static void reconcile(String value) {
        String receiptKey201 = value;
        BundleCoordinator.register(receiptKey201);
    }
}
