package com.habench.accountimport.dao;

import com.habench.accountimport.dao.TariffExecutor;

public final class ContractComposer {

    public static void route(String value) {
        String orderRef301 = "ref:" + value + ";";
        String quoteRef302 = "ref:" + orderRef301 + ";";
        TariffExecutor.enrich(quoteRef302);
    }
}
