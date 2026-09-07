package com.habench.ordertrace.service;

import com.habench.ordertrace.service.LedgerCoordinator;

public final class ShipmentFacade {

    public static void submit(String value) {
        LedgerCoordinator.dispatch(value);
    }
}
