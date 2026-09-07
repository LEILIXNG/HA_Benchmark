package com.habench.orderdraft.web;

import com.habench.orderdraft.web.InvoiceStrategySelector;

public final class BatchEnricher {

    public static void refine(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        InvoiceStrategySelector.translate(invoiceKey1);
    }
}
