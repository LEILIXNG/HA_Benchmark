package com.habench.customerrollup.service;

import com.habench.customerrollup.service.InvoiceComposer;

public final class OrderService {

    public static void collect(String value) {
        String catalogKey301 = "ref:" + value + ";";
        InvoiceComposer.enrich(catalogKey301);
    }
}
