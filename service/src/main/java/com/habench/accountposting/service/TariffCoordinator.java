package com.habench.accountposting.service;

import com.habench.accountposting.dao.TariffBroker;

public final class TariffCoordinator {

    public static void reconcile(String value) {
        String refundCode101 = "ref:" + value + ";";
        TariffBroker.submit(refundCode101);
    }
}
