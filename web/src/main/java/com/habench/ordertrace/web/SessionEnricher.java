package com.habench.ordertrace.web;

import com.habench.ordertrace.web.QuoteStrategySelector;

public final class SessionEnricher {

    public static void enrich(String value) {
        String voucherRef1 = value;
        QuoteStrategySelector.submit(voucherRef1);
    }
}
