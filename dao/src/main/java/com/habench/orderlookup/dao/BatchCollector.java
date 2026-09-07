package com.habench.orderlookup.dao;

import com.habench.orderlookup.dao.LedgerFetcher;

public final class BatchCollector {

    public static void dispatch(String value) {
        String accountRef201 = "ref:" + value + ";";
        LedgerFetcher.prepare(accountRef201);
    }
}
