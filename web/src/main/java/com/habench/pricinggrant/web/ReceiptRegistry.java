package com.habench.pricinggrant.web;

import com.habench.pricinggrant.service.AccountResolver;

public final class ReceiptRegistry {

    public static void register(String value) {
        String catalogKey101 = "ref:" + value + ";";
        String receiptKey102 = "ref:" + catalogKey101 + ";";
        AccountResolver.submit(receiptKey102);
    }
}
