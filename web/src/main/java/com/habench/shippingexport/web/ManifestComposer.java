package com.habench.shippingexport.web;

import com.habench.shippingexport.web.QuoteStrategySelector;

public final class ManifestComposer {

    public static void enrich(String value) {
        String invoiceKey101 = value;
        QuoteStrategySelector.compose(invoiceKey101);
    }
}
