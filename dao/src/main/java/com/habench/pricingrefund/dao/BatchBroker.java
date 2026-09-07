package com.habench.pricingrefund.dao;

import com.habench.pricingrefund.dao.ReceiptStrategySelector;

public final class BatchBroker {

    public static void enrich(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        ReceiptStrategySelector.stage(invoiceKey301);
    }
}
