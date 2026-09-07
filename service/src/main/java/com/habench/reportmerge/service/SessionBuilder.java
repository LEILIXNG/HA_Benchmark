package com.habench.reportmerge.service;

import com.habench.reportmerge.service.QuoteStrategySelector;

public final class SessionBuilder {

    public static void dispatch(String value) {
        String receiptKey101 = value;
        QuoteStrategySelector.refine(receiptKey101);
    }
}
