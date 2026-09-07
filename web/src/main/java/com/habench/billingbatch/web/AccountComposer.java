package com.habench.billingbatch.web;

import com.habench.billingbatch.web.ReceiptService;

public final class AccountComposer {

    public static void resolve(String value) {
        String receiptKey1 = value;
        ReceiptService.submit(receiptKey1);
    }
}
