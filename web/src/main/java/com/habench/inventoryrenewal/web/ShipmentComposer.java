package com.habench.inventoryrenewal.web;

import com.habench.inventoryrenewal.web.TariffEnricher;

public final class ShipmentComposer {

    public static void normalize(String value) {
        String accountRef1 = value;
        TariffEnricher.normalize(accountRef1);
    }
}
