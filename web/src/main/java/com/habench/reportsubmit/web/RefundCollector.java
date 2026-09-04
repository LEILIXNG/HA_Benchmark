package com.habench.reportsubmit.web;

import com.habench.reportsubmit.service.InvoiceCoordinator;

public final class RefundCollector {

    public static void route(String value) {
        String quoteRef101 = value;
        InvoiceCoordinator.publish(quoteRef101);
    }
}
