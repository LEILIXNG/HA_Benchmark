package com.habench.orderreview.service;

import com.habench.orderreview.dao.TariffCoordinator;

public final class ManifestService {

    public static void reconcile(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        TariffCoordinator.merge(shipmentCode201);
    }
}
