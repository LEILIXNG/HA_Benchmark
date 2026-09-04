package com.habench.billingapprove.service;

import com.habench.billingapprove.service.OrderLoader;

public final class InvoiceAssembler {

    public static void stage(String value) {
        String catalogKey201 = value;
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        OrderLoader.normalize(receiptKey202);
    }
}
