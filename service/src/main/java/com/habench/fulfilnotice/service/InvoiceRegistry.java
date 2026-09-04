package com.habench.fulfilnotice.service;

import com.habench.fulfilnotice.service.RefundExecutor;

public final class InvoiceRegistry {

    public static void expand(String value) {
        String orderRef101 = value;
        String quoteRef102 = "ref:" + orderRef101 + ";";
        RefundExecutor.compose(quoteRef102);
    }
}
