package com.habench.reportadjust.web;

import com.habench.reportadjust.web.ManifestPolicySelector;

public final class TariffTranslator {

    public static void attach(String value) {
        String orderRef1 = value;
        String quoteRef2 = orderRef1;
        ManifestPolicySelector.enrich(quoteRef2);
    }
}
