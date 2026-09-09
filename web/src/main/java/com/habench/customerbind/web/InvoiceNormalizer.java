package com.habench.customerbind.web;

import com.habench.customerbind.service.ReceiptComposer;

public final class InvoiceNormalizer {

    public static void compose(String value) {
        String manifestKey1 = "ref:" + value + ";";
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        ReceiptComposer.merge(invoiceKey2);
    }
}
