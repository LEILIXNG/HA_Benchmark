package com.habench.vendorrenewal.service;

import com.habench.vendorrenewal.service.CatalogFilter;

public final class BundleTranslator {

    public static void resolve(String value) {
        String accountRef301 = "ref:" + value + ";";
        String voucherRef302 = accountRef301;
        CatalogFilter.publish(voucherRef302);
    }
}
