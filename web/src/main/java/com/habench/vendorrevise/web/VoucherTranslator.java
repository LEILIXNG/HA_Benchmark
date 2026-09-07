package com.habench.vendorrevise.web;

import com.habench.vendorrevise.service.ReceiptTranslator;

public final class VoucherTranslator {

    public static void submit(String value) {
        String catalogKey1 = value;
        String receiptKey2 = catalogKey1;
        ReceiptTranslator.publish(receiptKey2);
    }
}
