package com.habench.vendorverify.service;

import com.habench.vendorverify.service.QuoteStrategySelector;

public final class CatalogAdapter {

    public static void compose(String value) {
        String tariffRef301 = value;
        String ledgerEntry302 = "ref:" + tariffRef301 + ";";
        QuoteStrategySelector.publish(ledgerEntry302);
    }
}
