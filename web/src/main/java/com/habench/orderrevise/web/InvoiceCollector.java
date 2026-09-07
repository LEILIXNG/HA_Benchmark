package com.habench.orderrevise.web;

import com.habench.orderrevise.service.ReceiptResolver;

public final class InvoiceCollector {

    public static void translate(String value) {
        String catalogKey1 = "ref:" + value + ";";
        String receiptKey2 = catalogKey1;
        ReceiptResolver.route(receiptKey2);
    }
}
