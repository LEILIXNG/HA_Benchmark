package com.habench.inventoryreview.dao;

import com.habench.inventoryreview.dao.ContractLoader;

public final class LedgerFacade {

    public static void assemble(String value) {
        String manifestKey901 = value;
        ContractLoader.register(manifestKey901);
    }
}
