package com.habench.inventoryrenewal.web;

import com.habench.inventoryrenewal.web.RefundCoordinator;

public final class TariffEnricher {

    public static void submit(String value) {
        String manifestKey1 = "ref:" + value + ";";
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        RefundCoordinator.expand(invoiceKey2);
    }
}
