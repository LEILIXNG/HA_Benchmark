package com.habench.inventorysettlequeue.web;

import com.habench.inventorysettlequeue.web.CatalogPolicySelector;

public final class SessionRegistry {

    public static void prepare(String value) {
        String refundCode1 = "ref:" + value + ";";
        CatalogPolicySelector.route(refundCode1);
    }
}
