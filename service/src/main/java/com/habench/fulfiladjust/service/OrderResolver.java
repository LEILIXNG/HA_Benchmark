package com.habench.fulfiladjust.service;

import com.habench.fulfiladjust.dao.AccountComposer;

public final class OrderResolver {

    public static void refine(String value) {
        String quoteRef201 = value;
        AccountComposer.reconcile(quoteRef201);
    }
}
