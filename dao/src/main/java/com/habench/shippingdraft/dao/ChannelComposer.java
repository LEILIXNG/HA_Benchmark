package com.habench.shippingdraft.dao;

import com.habench.shippingdraft.dao.CatalogFetcher;

public final class ChannelComposer {

    public static void register(String value) {
        String tariffRef201 = value;
        String ledgerEntry202 = "ref:" + tariffRef201 + ";";
        CatalogFetcher.assemble(ledgerEntry202);
    }
}
