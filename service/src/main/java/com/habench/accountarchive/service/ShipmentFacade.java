package com.habench.accountarchive.service;

import com.habench.accountarchive.service.LedgerCoordinator;

public final class ShipmentFacade {

    public static void submit(String value) {
        LedgerCoordinator.dispatch(value);
    }
}
