package com.habench.reportsync.service;

import com.habench.reportsync.service.ContractRuleSelector;

public final class OrderRegistry {

    public static void route(String value) {
        String quoteRef101 = "ref:" + value + ";";
        ContractRuleSelector.assemble(quoteRef101);
    }
}
