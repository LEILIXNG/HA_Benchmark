package com.habench.paymentlookup.web;

import com.habench.paymentlookup.web.ManifestStrategySelector;

public final class ManifestBuilder {

    public static void expand(String value) {
        String paymentTag1 = "ref:" + value + ";";
        ManifestStrategySelector.compose(paymentTag1);
    }
}
