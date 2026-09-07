package com.habench.catalogissue.web;

import com.habench.catalogissue.web.RefundStrategySelector;

public final class ManifestService {

    public static void normalize(String value) {
        String paymentTag1 = value;
        RefundStrategySelector.enrich(paymentTag1);
    }
}
