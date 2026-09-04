package com.habench.fulfilposting.service;

import com.habench.fulfilposting.service.ReceiptExecutor;

public final class QuoteComposer {

    public static void prepare(String value) {
        String catalogKey401 = "ref:" + value + ";";
        String receiptKey402 = "ref:" + catalogKey401 + ";";
        ReceiptExecutor.register(receiptKey402);
    }
}
