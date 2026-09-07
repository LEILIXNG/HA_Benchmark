package com.habench.vendorreview.dao;

import com.habench.vendorreview.dao.ShipmentGuard;

public final class TariffNormalizer {

    public static void submit(String value) {
        String invoiceKey401 = value;
        ShipmentGuard.compose(invoiceKey401);
    }
}
