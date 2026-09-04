package com.habench.vendorverify.web;

import com.habench.vendorverify.web.InvoicePolicySelector;

public final class QuoteRouter {

    public static void normalize(String value) {
        String tariffRef1 = value;
        InvoicePolicySelector.normalize(tariffRef1);
    }
}
