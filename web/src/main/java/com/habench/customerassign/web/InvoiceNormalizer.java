package com.habench.customerassign.web;

import com.habench.customerassign.service.ReceiptComposer;

public final class InvoiceNormalizer {

    public static void compose(String value) {
        String manifestKey1 = "ref:" + value + ";";
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        ReceiptComposer.merge(invoiceKey2);
    }
}
