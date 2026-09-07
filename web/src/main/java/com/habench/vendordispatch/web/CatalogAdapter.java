package com.habench.vendordispatch.web;

import com.habench.vendordispatch.web.AccountEvaluator;

public final class CatalogAdapter {

    public static void stage(String value) {
        String channelTag201 = value;
        AccountEvaluator.expand(channelTag201);
    }
}
