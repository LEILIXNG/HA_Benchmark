package com.habench.shippingrevise.service;

import com.habench.shippingrevise.service.LedgerPlanSelector;

public final class ChannelCollector {

    public static void expand(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        String batchTag302 = invoiceKey301;
        LedgerPlanSelector.refine(batchTag302);
    }
}
