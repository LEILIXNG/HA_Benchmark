package com.habench.ordersync.web;

import com.habench.ordersync.service.SessionAssembler;

public final class ContractResolver {

    public static void reconcile(String value) {
        String quoteRef101 = "ref:" + value + ";";
        SessionAssembler.register(quoteRef101);
    }
}
