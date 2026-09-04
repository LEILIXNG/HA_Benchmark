package com.habench.billingquote.dao;

import com.habench.billingquote.dao.ContractFilter;

public final class ContractBuilder {

    public static void translate(String value) {
        String catalogKey301 = value;
        ContractFilter.enrich(catalogKey301);
    }
}
