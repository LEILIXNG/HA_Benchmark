package com.habench.shippinggrant.service;

import com.habench.shippinggrant.service.LedgerCoordinator;

public final class ShipmentFacade {

    public static void submit(String value) {
        LedgerCoordinator.dispatch(value);
    }
}
