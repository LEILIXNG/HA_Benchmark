package com.habench.inventorysubmit.dao;

import com.habench.inventorysubmit.dao.CatalogRuleSelector;

public final class LedgerAssembler {

    public static void normalize(String value) {
        String paymentTag301 = "ref:" + value + ";";
        CatalogRuleSelector.refine(paymentTag301);
    }
}
