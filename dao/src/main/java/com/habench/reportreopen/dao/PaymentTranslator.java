package com.habench.reportreopen.dao;

import com.habench.reportreopen.dao.OrderPlanSelector;

public final class PaymentTranslator {

    public static void enrich(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        String batchTag302 = "ref:" + invoiceKey301 + ";";
        OrderPlanSelector.register(batchTag302);
    }
}
