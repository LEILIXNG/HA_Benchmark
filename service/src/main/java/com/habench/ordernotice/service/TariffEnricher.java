package com.habench.ordernotice.service;

import com.habench.ordernotice.service.CatalogService;

public final class TariffEnricher {

    public static void publish(String value) {
        String voucherRef501 = value;
        CatalogService.resolve(voucherRef501);
    }
}
