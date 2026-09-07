package com.habench.fulfiladjust.service;

import com.habench.fulfiladjust.service.RefundPolicySelector;

public final class ReceiptCollector {

    public static void expand(String value) {
        String receiptKey101 = "ref:" + value + ";";
        RefundPolicySelector.forward(receiptKey101);
    }
}
