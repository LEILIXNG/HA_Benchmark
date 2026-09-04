package com.habench.billingrollup.dao;

import com.habench.billingrollup.dao.OrderLoader;

public final class QuoteTranslator {

    public static void reconcile(String value) {
        String batchTag201 = "ref:" + value + ";";
        OrderLoader.publish(batchTag201);
    }
}
