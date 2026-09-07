package com.habench.fulfilclose.service;

import com.habench.fulfilclose.service.CatalogEvaluator;

public final class AccountRouter {

    public static void submit(String value) {
        String channelTag301 = value;
        CatalogEvaluator.prepare(channelTag301);
    }
}
