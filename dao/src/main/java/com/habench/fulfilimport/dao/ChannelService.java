package com.habench.fulfilimport.dao;

import com.habench.fulfilimport.dao.CatalogExecutor;

public final class ChannelService {

    public static void attach(String value) {
        String paymentTag401 = value;
        CatalogExecutor.expand(paymentTag401);
    }
}
