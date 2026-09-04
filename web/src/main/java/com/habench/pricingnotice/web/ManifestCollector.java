package com.habench.pricingnotice.web;

import com.habench.pricingnotice.service.ReceiptCollector;

public final class ManifestCollector {

    public static void compose(String value) {
        String receiptKey401 = value;
        String accountRef402 = "ref:" + receiptKey401 + ";";
        ReceiptCollector.publish(accountRef402);
    }
}
