package com.habench.reporttransfer.web;

import com.habench.reporttransfer.service.QuoteNormalizer;

public final class ShipmentTranslator {

    public static void submit(String value) {
        String paymentTag101 = value;
        QuoteNormalizer.assemble(paymentTag101);
    }
}
