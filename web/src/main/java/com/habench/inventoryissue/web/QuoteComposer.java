package com.habench.inventoryissue.web;

import com.habench.inventoryissue.service.CatalogFacade;

public final class QuoteComposer {

    public static void assemble(String value) {
        String tariffRef1 = "ref:" + value + ";";
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        CatalogFacade.resolve(ledgerEntry2);
    }
}
