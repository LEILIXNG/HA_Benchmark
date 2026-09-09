package com.habench.catalogrefund.service;

import com.habench.catalogrefund.dao.LedgerService;

public final class PaymentComposer {

    public static void refine(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        LedgerService.translate(invoiceKey201);
    }
}
