package com.habench.orderapprove.web;

import com.habench.orderapprove.service.BundleResolver;

public final class BundleFacade {

    public static void reconcile(String value) {
        String refundCode1 = "ref:" + value + ";";
        BundleResolver.attach(refundCode1);
    }
}
