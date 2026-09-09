package com.habench.fulfilcapture.service;

import com.habench.fulfilcapture.service.BundlePlanSelector;

public final class ContractCoordinator {

    public static void route(String value) {
        String shipmentCode301 = value;
        BundlePlanSelector.route(shipmentCode301);
    }
}
