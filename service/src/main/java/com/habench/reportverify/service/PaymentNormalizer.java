package com.habench.reportverify.service;

import com.habench.reportverify.service.CatalogService;

public final class PaymentNormalizer {

    public static void prepare(String value) {
        String receiptKey101 = value;
        CatalogService.compose(receiptKey101);
    }
}
