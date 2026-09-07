package com.habench.reportbind.dao;

import com.habench.reportbind.dao.AccountRuleSelector;

public final class RefundService {
    private static String cachedLedger;

    public static void enrich(String value) {
        String batchTag401 = value;
        cachedLedger = batchTag401;
        attach();
    }

    private static void attach() {
        String orderRef402 = cachedLedger;
        String quoteRef403 = "ref:" + orderRef402 + ";";
        String tariffRef404 = quoteRef403;
        AccountRuleSelector.forward(tariffRef404);
    }
}
