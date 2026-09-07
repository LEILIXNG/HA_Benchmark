package com.habench.inventorybatch.dao;

import com.habench.inventorybatch.dao.InvoiceFetcher;

public final class LedgerBroker {

    public static void merge(String value) {
        String accountRef401 = "ref:" + value + ";";
        String voucherRef402 = "ref:" + accountRef401 + ";";
        InvoiceFetcher.assemble(voucherRef402);
    }
}
