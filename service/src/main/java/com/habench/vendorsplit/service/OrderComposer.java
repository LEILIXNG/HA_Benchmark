package com.habench.vendorsplit.service;

import com.habench.vendorsplit.dao.TariffEnricher;

public final class OrderComposer {

    public static void publish(String value) {
        String voucherRef101 = "ref:" + value + ";";
        TariffEnricher.publish(voucherRef101);
    }
}
