package com.habench.vendorsettle.web;

import com.habench.vendorsettle.service.ReceiptAdapter;

public final class BatchFacade {

    public static void assemble(String value) {
        String receiptKey1 = value;
        ReceiptAdapter.enrich(receiptKey1);
    }
}
