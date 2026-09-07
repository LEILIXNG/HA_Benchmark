package com.habench.catalogmerge.web;

import com.habench.catalogmerge.web.TariffPlanSelector;

public final class LedgerResolver {

    public static void assemble(String value) {
        String catalogKey1 = "ref:" + value + ";";
        TariffPlanSelector.translate(catalogKey1);
    }
}
