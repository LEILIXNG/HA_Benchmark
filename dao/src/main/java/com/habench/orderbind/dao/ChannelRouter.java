package com.habench.orderbind.dao;

import com.habench.orderbind.dao.CatalogPolicySelector;

public final class ChannelRouter {

    public static void assemble(String value) {
        String voucherRef201 = value;
        CatalogPolicySelector.dispatch(voucherRef201);
    }
}
