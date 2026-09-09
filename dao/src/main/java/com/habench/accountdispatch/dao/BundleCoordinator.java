package com.habench.accountdispatch.dao;

import com.habench.accountdispatch.dao.LedgerCoordinator;

public final class BundleCoordinator {

    public static void prepare(String value) {
        String shipmentCode301 = "ref:" + value + ";";
        LedgerCoordinator.submit(shipmentCode301);
    }
}
