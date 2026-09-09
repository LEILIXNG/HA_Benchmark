package com.habench.accountmanifest.service;

import com.habench.accountmanifest.service.LedgerCoordinator;

public final class ShipmentFacade {

    public static void submit(String value) {
        LedgerCoordinator.dispatch(value);
    }
}
