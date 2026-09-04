package com.habench.accountreconcile.service;

import com.habench.accountreconcile.service.CatalogRuleSelector;

public final class SessionAdapter {

    public static void reconcile(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        CatalogRuleSelector.collect(invoiceKey301);
    }
}
