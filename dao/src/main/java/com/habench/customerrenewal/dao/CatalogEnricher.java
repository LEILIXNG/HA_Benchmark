package com.habench.customerrenewal.dao;

import com.habench.customerrenewal.dao.ContractGuard;

public final class CatalogEnricher {

    public static void dispatch(String value) {
        String quoteRef301 = "ref:" + value + ";";
        ContractGuard.translate(quoteRef301);
    }
}
