package com.habench.paymentsettlequeue.dao;

import com.habench.paymentsettlequeue.dao.CatalogRuleSelector;

public final class PaymentCollector {

    public static void attach(String value) {
        String orderRef201 = "ref:" + value + ";";
        String quoteRef202 = orderRef201;
        CatalogRuleSelector.enrich(quoteRef202);
    }
}
