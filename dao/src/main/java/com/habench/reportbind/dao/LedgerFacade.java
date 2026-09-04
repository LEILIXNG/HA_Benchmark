package com.habench.reportbind.dao;

import com.habench.reportbind.dao.ContractLoader;

public final class LedgerFacade {

    public static void assemble(String value) {
        String ledgerEntry401 = value;
        ContractLoader.register(ledgerEntry401);
    }
}
