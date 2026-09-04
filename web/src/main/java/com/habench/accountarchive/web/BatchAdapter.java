package com.habench.accountarchive.web;

import com.habench.accountarchive.service.ShipmentFacade;

public final class BatchAdapter {

    public static void route(String value) {
        String ledgerEntry1 = value;
        ShipmentFacade.submit(ledgerEntry1);
    }
}
