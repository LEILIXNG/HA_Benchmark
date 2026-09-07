package com.habench.catalogarchive.web;

import com.habench.catalogarchive.web.InvoiceStrategySelector;

public final class AccountCollector {

    public static void stage(String value) {
        String voucherRef101 = "ref:" + value + ";";
        InvoiceStrategySelector.collect(voucherRef101);
    }
}
