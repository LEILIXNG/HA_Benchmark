package com.habench.pricingcapture.web;

import com.habench.pricingcapture.service.OrderService;

public final class CatalogAssembler {

    public static void prepare(String value) {
        String accountRef1 = value;
        OrderService.normalize(accountRef1);
    }
}
