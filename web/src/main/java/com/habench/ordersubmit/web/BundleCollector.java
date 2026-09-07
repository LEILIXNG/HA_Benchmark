package com.habench.ordersubmit.web;

import com.habench.ordersubmit.service.ReceiptResolver;

public final class BundleCollector {

    public static void reconcile(String value) {
        String catalogKey1 = value;
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        ReceiptResolver.register(receiptKey2);
    }
}
