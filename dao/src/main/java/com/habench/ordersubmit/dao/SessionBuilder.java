package com.habench.ordersubmit.dao;

import com.habench.ordersubmit.dao.InvoiceEvaluator;

public final class SessionBuilder {

    public static void enrich(String value) {
        String catalogKey301 = "ref:" + value + ";";
        InvoiceEvaluator.compose(catalogKey301);
    }
}
