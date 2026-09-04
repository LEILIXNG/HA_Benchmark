package com.habench.ordertrace.service;

import com.habench.ordertrace.service.AccountScreen;

public final class ManifestFacade {

    public static void expand(String value) {
        String ledgerEntry401 = value;
        String channelTag402 = ledgerEntry401;
        AccountScreen.reconcile(channelTag402);
    }
}
