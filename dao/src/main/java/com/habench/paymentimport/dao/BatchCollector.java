package com.habench.paymentimport.dao;

import com.habench.paymentimport.dao.LedgerFetcher;

public final class BatchCollector {

    public static void dispatch(String value) {
        String accountRef201 = "ref:" + value + ";";
        LedgerFetcher.prepare(accountRef201);
    }
}
