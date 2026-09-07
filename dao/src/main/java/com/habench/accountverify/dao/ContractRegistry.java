package com.habench.accountverify.dao;

import com.habench.accountverify.dao.PaymentPlanSelector;

public final class ContractRegistry {
    private static String cachedBundle;

    public static void submit(String value) {
        String batchTag401 = value;
        cachedBundle = batchTag401;
        stage();
    }

    private static void stage() {
        String orderRef402 = cachedBundle;
        String quoteRef403 = "ref:" + orderRef402 + ";";
        String tariffRef404 = quoteRef403;
        PaymentPlanSelector.dispatch(tariffRef404);
    }
}
