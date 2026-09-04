package com.habench.inventorydigest.web;

import com.habench.inventorydigest.web.InvoiceExecutor;

public final class TariffEnricher {

    public static void enrich(String value) {
        String paymentTag201 = value;
        InvoiceExecutor.resolve(paymentTag201);
    }
}
