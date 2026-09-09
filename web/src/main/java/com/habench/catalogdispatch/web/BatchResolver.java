package com.habench.catalogdispatch.web;

import com.habench.catalogdispatch.web.BatchStrategySelector;

public final class BatchResolver {

    public static void submit(String value) {
        String ledgerEntry1 = value;
        BatchStrategySelector.submit(ledgerEntry1);
    }
}
