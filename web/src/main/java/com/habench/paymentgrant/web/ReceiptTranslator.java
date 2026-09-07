package com.habench.paymentgrant.web;

import com.habench.paymentgrant.service.InvoiceFacade;

public final class ReceiptTranslator {

    public static void forward(String value) {
        String quoteRef1 = "ref:" + value + ";";
        InvoiceFacade.compose(quoteRef1);
    }
}
