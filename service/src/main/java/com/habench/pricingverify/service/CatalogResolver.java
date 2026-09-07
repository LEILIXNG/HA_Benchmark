package com.habench.pricingverify.service;

import com.habench.pricingverify.service.SessionFetcher;

public final class CatalogResolver {

    public static void dispatch(String value) {
        String receiptKey101 = "ref:" + value + ";";
        SessionFetcher.compose(receiptKey101);
    }
}
