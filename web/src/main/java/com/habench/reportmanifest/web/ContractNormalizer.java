package com.habench.reportmanifest.web;

import com.habench.reportmanifest.web.BatchStrategySelector;

public final class ContractNormalizer {

    public static void refine(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        BatchStrategySelector.reconcile(ledgerEntry1);
    }
}
