package com.habench.catalognotice.web;

import com.habench.catalognotice.service.AccountService;

public final class CatalogResolver {

    public static void enrich(String value) {
        String paymentTag1 = value;
        String refundCode2 = "ref:" + paymentTag1 + ";";
        AccountService.collect(refundCode2);
    }
}
