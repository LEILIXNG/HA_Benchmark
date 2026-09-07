package com.habench.reportadjust.web;

import com.habench.reportadjust.service.TariffRegistry;

public final class AccountBroker {

    public static void refine(String value) {
        String catalogKey101 = "ref:" + value + ";";
        TariffRegistry.submit(catalogKey101);
    }
}
