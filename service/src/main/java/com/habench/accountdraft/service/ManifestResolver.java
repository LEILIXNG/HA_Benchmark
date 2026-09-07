package com.habench.accountdraft.service;

import com.habench.accountdraft.service.OrderBuilder;

public final class ManifestResolver {

    public static void register(String value) {
        String receiptKey201 = "ref:" + value + ";";
        OrderBuilder.reconcile(receiptKey201);
    }
}
