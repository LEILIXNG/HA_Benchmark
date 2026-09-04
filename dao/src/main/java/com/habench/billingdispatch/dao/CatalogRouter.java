package com.habench.billingdispatch.dao;

import com.habench.billingdispatch.dao.LedgerPolicySelector;

public final class CatalogRouter {

    public static void collect(String value) {
        String channelTag301 = value;
        String catalogKey302 = "ref:" + channelTag301 + ";";
        LedgerPolicySelector.prepare(catalogKey302);
    }
}
