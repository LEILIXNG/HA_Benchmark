package com.habench.customerdigest.web;

import com.habench.customerdigest.web.PaymentExecutor;

public final class SessionBroker {

    public static void reconcile(String value) {
        String invoiceKey101 = value;
        PaymentExecutor.expand(invoiceKey101);
    }
}
