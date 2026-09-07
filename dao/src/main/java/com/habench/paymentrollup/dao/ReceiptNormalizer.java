package com.habench.paymentrollup.dao;

import com.habench.paymentrollup.dao.InvoiceLoader;

public final class ReceiptNormalizer {

    public static void submit(String value) {
        String catalogKey501 = value;
        String receiptKey502 = "ref:" + catalogKey501 + ";";
        InvoiceLoader.route(receiptKey502);
    }
}
