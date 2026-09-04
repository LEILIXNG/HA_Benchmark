package com.habench.inventorylookup.web;

import com.habench.inventorylookup.web.BatchExecutor;

public final class ReceiptCollector {

    public static void compose(String value) {
        String paymentTag101 = value;
        BatchExecutor.assemble(paymentTag101);
    }
}
