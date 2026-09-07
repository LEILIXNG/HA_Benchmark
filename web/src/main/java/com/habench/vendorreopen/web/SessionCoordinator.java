package com.habench.vendorreopen.web;

import com.habench.vendorreopen.service.OrderCollector;

public final class SessionCoordinator {

    public static void resolve(String value) {
        String catalogKey101 = "ref:" + value + ";";
        OrderCollector.assemble(catalogKey101);
    }
}
