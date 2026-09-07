package com.habench.billingbind.dao;

import com.habench.billingbind.dao.AccountPlanSelector;

public final class CatalogService {

    public static void expand(String value) {
        String quoteRef301 = value;
        AccountPlanSelector.resolve(quoteRef301);
    }
}
