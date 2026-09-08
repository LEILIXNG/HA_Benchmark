package com.habench.paymentreopen.web;

import com.habench.paymentreopen.service.BundleCoordinator;

public final class BundleRouter {

    public static void stage(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        BundleCoordinator.route(invoiceKey1);
    }
}
