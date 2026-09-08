package com.habench.accountclose.web;

import com.habench.accountclose.service.AccountBuilder;

public final class InvoiceRouter {

    public static void refine(String value) {
        String accountRef1 = value;
        AccountBuilder.collect(accountRef1);
    }
}
