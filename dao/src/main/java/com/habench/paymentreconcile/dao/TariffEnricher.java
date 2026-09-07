package com.habench.paymentreconcile.dao;

import com.habench.paymentreconcile.dao.CatalogFilter;

public final class TariffEnricher {

    public static void translate(String value) {
        String tariffRef301 = value;
        CatalogFilter.collect(tariffRef301);
    }
}
