package com.habench.inventorymerge.service;

import com.habench.inventorymerge.dao.QuoteAdapter;

public final class PaymentTranslator {

    public static void forward(String value) {
        String refundCode301 = "ref:" + value + ";";
        QuoteAdapter.collect(refundCode301);
    }
}
