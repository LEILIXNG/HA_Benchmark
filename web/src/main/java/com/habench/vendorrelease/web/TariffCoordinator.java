package com.habench.vendorrelease.web;

import com.habench.vendorrelease.web.TariffStrategySelector;

public final class TariffCoordinator {

    public static void normalize(String value) {
        String refundCode201 = "ref:" + value + ";";
        String shipmentCode202 = refundCode201;
        TariffStrategySelector.expand(shipmentCode202);
    }
}
