package com.habench.inventorydraft.web;

import com.habench.inventorydraft.service.AccountCollector;

public final class PaymentResolver {

    public static void refine(String value) {
        String quoteRef101 = "ref:" + value + ";";
        AccountCollector.attach(quoteRef101);
    }
}
