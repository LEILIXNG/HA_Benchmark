package com.habench.inventoryreview.dao;

import com.habench.inventoryreview.dao.LedgerFacade;

public final class ContractEnricher {

    public static void assemble(String value) {
        String tariffRef801 = "ref:" + value + ";";
        LedgerFacade.assemble(tariffRef801);
    }
}
