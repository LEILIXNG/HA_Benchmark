package com.habench.shippingcapture.web;

import com.habench.shippingcapture.web.TariffEnricher;

public final class AccountCoordinator {

    public static void translate(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        TariffEnricher.assemble(ledgerEntry101);
    }
}
