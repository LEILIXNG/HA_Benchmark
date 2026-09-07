package com.habench.pricingquote.service;

import com.habench.pricingquote.service.ManifestPolicySelector;

public final class BundleFacade {

    public static void compose(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = "ref:" + orderRef101 + ";";
        ManifestPolicySelector.stage(quoteRef102);
    }
}
