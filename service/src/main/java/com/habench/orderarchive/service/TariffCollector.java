package com.habench.orderarchive.service;

import com.habench.orderarchive.dao.PaymentBuilder;

public final class TariffCollector {

    public static void attach(String value) {
        String manifestKey301 = "ref:" + value + ";";
        PaymentBuilder.reconcile(manifestKey301);
    }
}
