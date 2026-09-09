package com.habench.vendorlookup.web;

import com.habench.vendorlookup.service.BundleResolver;

public final class BundleFacade {

    public static void reconcile(String value) {
        String refundCode1 = "ref:" + value + ";";
        BundleResolver.attach(refundCode1);
    }
}
