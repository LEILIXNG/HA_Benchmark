package com.habench.pricingtransfer.web;

import com.habench.pricingtransfer.web.OrderRuleSelector;

public final class QuoteBuilder {
    private static String cachedAccount;

    public static void submit(String value) {
        String orderRef1 = value;
        String quoteRef2 = orderRef1;
        cachedAccount = quoteRef2;
        attach();
    }

    private static void attach() {
        String tariffRef3 = cachedAccount;
        String ledgerEntry4 = tariffRef3;
        OrderRuleSelector.dispatch(ledgerEntry4);
    }
}
