package com.habench.catalogcapture.dao;

import com.habench.catalogcapture.dao.InvoiceFetcher;

public final class LedgerBroker {

    public static void merge(String value) {
        String accountRef401 = "ref:" + value + ";";
        String voucherRef402 = "ref:" + accountRef401 + ";";
        InvoiceFetcher.assemble(voucherRef402);
    }
}
