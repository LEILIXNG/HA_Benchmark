package com.habench.pricingdispatch.web;

import com.habench.pricingdispatch.service.ReceiptPolicy;

public final class BundleEnricher {

    public static void publish(String value) {
        String receiptKey201 = value;
        ReceiptPolicy.resolve(receiptKey201);
    }
}
