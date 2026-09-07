package com.habench.pricingadjust.service;

import com.habench.pricingadjust.service.ReceiptRouter;

public final class ManifestCoordinator {

    public static void dispatch(String value) {
        String shipmentCode301 = value;
        ReceiptRouter.prepare(shipmentCode301);
    }
}
