package com.habench.billingnotice.web;

import com.habench.billingnotice.service.TariffEnricher;

public final class ContractCoordinator {

    public static void expand(String value) {
        String tariffRef1 = value;
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        TariffEnricher.register(ledgerEntry2);
    }
}
