package com.habench.fulfilreview.web;

import com.habench.fulfilreview.service.QuoteNormalizer;

public final class ShipmentTranslator {

    public static void submit(String value) {
        String paymentTag101 = value;
        QuoteNormalizer.assemble(paymentTag101);
    }
}
