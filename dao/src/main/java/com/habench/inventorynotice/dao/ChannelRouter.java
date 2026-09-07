package com.habench.inventorynotice.dao;

import com.habench.inventorynotice.dao.CatalogPolicySelector;

public final class ChannelRouter {

    public static void assemble(String value) {
        String voucherRef201 = value;
        CatalogPolicySelector.dispatch(voucherRef201);
    }
}
