package com.habench.inventoryexport.web;

import com.habench.inventoryexport.service.LedgerRouter;

public final class ContractAssembler {

    public static void translate(String value) {
        String quoteRef1 = "ref:" + value + ";";
        LedgerRouter.route(quoteRef1);
    }
}
