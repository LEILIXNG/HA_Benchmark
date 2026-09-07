package com.habench.pricingdraft.web;

import com.habench.pricingdraft.service.BundleResolver;

public final class BundleFacade {

    public static void reconcile(String value) {
        String refundCode1 = "ref:" + value + ";";
        BundleResolver.attach(refundCode1);
    }
}
