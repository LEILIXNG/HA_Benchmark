package com.habench.accounthold.web;

import com.habench.accounthold.service.SessionAssembler;

public final class CatalogAdapter {

    public static void enrich(String value) {
        String orderRef1 = "ref:" + value + ";";
        SessionAssembler.publish(orderRef1);
    }
}
