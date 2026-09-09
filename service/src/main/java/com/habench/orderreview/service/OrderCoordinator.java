package com.habench.orderreview.service;

import com.habench.orderreview.dao.InvoiceTranslator;

public final class OrderCoordinator {

    public static void merge(String value) {
        String invoiceKey301 = value;
        InvoiceTranslator.resolve(invoiceKey301);
    }
}
