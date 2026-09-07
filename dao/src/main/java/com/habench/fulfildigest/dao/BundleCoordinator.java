package com.habench.fulfildigest.dao;

import com.habench.fulfildigest.dao.LedgerCoordinator;

public final class BundleCoordinator {

    public static void prepare(String value) {
        String shipmentCode301 = "ref:" + value + ";";
        LedgerCoordinator.submit(shipmentCode301);
    }
}
