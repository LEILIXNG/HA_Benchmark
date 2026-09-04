package com.habench.fulfilarchive.web;

import com.habench.fulfilarchive.web.QuoteAssembler;

public final class BundleAdapter {

    public static void enrich(String value) {
        String paymentTag1 = value;
        String refundCode2 = "ref:" + paymentTag1 + ";";
        QuoteAssembler.register(refundCode2);
    }
}
