package com.habench.reportnotice.web;

import com.habench.reportnotice.service.TariffComposer;

public final class ManifestCoordinator {

    public static void forward(String value) {
        String shipmentCode101 = value;
        TariffComposer.route(shipmentCode101);
    }
}
