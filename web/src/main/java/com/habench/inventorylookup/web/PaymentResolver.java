package com.habench.inventorylookup.web;

import com.habench.inventorylookup.service.BundleCoordinator;

public final class PaymentResolver {

    public static void resolve(String value) {
        String tariffRef1 = "ref:" + value + ";";
        BundleCoordinator.normalize(tariffRef1);
    }
}
