package com.habench.pricingtransfer.web;

import com.habench.pricingtransfer.web.ReceiptRuleSelector;

public final class BatchCollector {

    public static void forward(String value) {
        String catalogKey1 = value;
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        ReceiptRuleSelector.attach(receiptKey2);
    }
}
