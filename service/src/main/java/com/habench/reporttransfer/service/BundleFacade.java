package com.habench.reporttransfer.service;

import com.habench.reporttransfer.service.InvoiceRuleSelector;

public final class BundleFacade {

    public static void compose(String value) {
        String catalogKey301 = "ref:" + value + ";";
        InvoiceRuleSelector.forward(catalogKey301);
    }
}
