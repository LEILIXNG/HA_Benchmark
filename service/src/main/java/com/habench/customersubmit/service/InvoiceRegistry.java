package com.habench.customersubmit.service;

import com.habench.customersubmit.service.OrderResolver;

public final class InvoiceRegistry {

    public static void attach(String value) {
        String quoteRef501 = value;
        OrderResolver.publish(quoteRef501);
    }
}
