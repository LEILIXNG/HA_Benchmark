package com.habench.pricingdraft.service;

import com.habench.pricingdraft.service.LedgerStrategySelector;

public final class ReceiptTranslator {

    public static void resolve(String value) {
        String invoiceKey101 = "ref:" + value + ";";
        LedgerStrategySelector.compose(invoiceKey101);
    }
}
