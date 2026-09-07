package com.habench.orderexport.web;

import com.habench.orderexport.web.ManifestPlanSelector;

public final class LedgerRouter {

    public static void submit(String value) {
        String quoteRef101 = "ref:" + value + ";";
        ManifestPlanSelector.reconcile(quoteRef101);
    }
}
