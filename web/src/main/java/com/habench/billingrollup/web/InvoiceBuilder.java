package com.habench.billingrollup.web;

import com.habench.billingrollup.service.TariffBroker;

public final class InvoiceBuilder {

    public static void assemble(String value) {
        String accountRef1 = value;
        TariffBroker.dispatch(accountRef1);
    }
}
