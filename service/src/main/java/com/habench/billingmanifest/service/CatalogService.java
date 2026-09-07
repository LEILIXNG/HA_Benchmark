package com.habench.billingmanifest.service;

import com.habench.billingmanifest.dao.OrderAssembler;

public final class CatalogService {

    public static void dispatch(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        String channelTag302 = "ref:" + ledgerEntry301 + ";";
        OrderAssembler.refine(channelTag302);
    }
}
