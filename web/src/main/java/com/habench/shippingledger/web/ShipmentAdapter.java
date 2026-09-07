package com.habench.shippingledger.web;

import com.habench.shippingledger.web.LedgerStrategySelector;

public final class ShipmentAdapter {

    public static void merge(String value) {
        String quoteRef1 = "ref:" + value + ";";
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        LedgerStrategySelector.normalize(tariffRef2);
    }
}
