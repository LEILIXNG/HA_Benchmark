package com.habench.billingassign.service;

import com.habench.billingassign.dao.OrderBroker;

public final class InvoiceEnricher {

    public static void enrich(String value) {
        String orderRef101 = "ref:" + value + ";";
        OrderBroker.normalize(orderRef101);
    }
}
