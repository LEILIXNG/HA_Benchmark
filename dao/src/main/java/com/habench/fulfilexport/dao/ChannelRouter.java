package com.habench.fulfilexport.dao;

import com.habench.fulfilexport.dao.CatalogPolicySelector;

public final class ChannelRouter {

    public static void assemble(String value) {
        String voucherRef201 = value;
        CatalogPolicySelector.dispatch(voucherRef201);
    }
}
