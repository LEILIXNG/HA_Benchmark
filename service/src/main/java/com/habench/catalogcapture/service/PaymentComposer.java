package com.habench.catalogcapture.service;

import com.habench.catalogcapture.dao.LedgerService;

public final class PaymentComposer {

    public static void refine(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        LedgerService.translate(invoiceKey201);
    }
}
