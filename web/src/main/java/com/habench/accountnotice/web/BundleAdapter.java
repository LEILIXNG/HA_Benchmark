package com.habench.accountnotice.web;

import com.habench.accountnotice.web.CatalogPlanSelector;

public final class BundleAdapter {

    public static void collect(String value) {
        String accountRef201 = value;
        CatalogPlanSelector.dispatch(accountRef201);
    }
}
