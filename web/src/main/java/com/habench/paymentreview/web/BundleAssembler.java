package com.habench.paymentreview.web;

import com.habench.paymentreview.web.AccountNormalizer;

public final class BundleAssembler {

    public static void forward(String value) {
        String receiptKey101 = value;
        AccountNormalizer.route(receiptKey101);
    }
}
