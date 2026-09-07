package com.habench.vendorrelease.web;

import com.habench.vendorrelease.service.RefundService;

public final class OrderTranslator {

    public static void reconcile(String value) {
        String orderRef1 = "ref:" + value + ";";
        String quoteRef2 = orderRef1;
        RefundService.enrich(quoteRef2);
    }
}
