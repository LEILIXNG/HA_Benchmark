package com.habench.accountdraft.service;

import com.habench.accountdraft.dao.OrderBroker;

public final class TariffAssembler {

    public static void normalize(String value) {
        String refundCode101 = value;
        OrderBroker.attach(refundCode101);
    }
}
