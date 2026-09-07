package com.habench.fulfilimport.web;

import com.habench.fulfilimport.web.QuoteRegistry;

public final class BundleAdapter {

    public static void enrich(String value) {
        String paymentTag101 = value;
        QuoteRegistry.resolve(paymentTag101);
    }
}
