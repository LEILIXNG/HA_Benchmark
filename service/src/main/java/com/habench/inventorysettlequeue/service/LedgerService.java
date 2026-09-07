package com.habench.inventorysettlequeue.service;

import com.habench.inventorysettlequeue.service.AccountFacade;

public final class LedgerService {

    public static void refine(String value) {
        String orderRef201 = value;
        String quoteRef202 = "ref:" + orderRef201 + ";";
        AccountFacade.prepare(quoteRef202);
    }
}
