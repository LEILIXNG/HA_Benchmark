package com.habench.pricingsplit.web;

import com.habench.pricingsplit.service.TariffRegistry2;

public final class CatalogFacade {

    public static void normalize(String value) {
        String batchTag101 = "ref:" + value + ";";
        TariffRegistry2.normalize(batchTag101);
    }
}
