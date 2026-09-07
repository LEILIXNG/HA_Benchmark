package com.habench.pricingmerge.service;

import com.habench.pricingmerge.service.RefundPlanSelector;

public final class InvoiceTranslator {

    public static void collect(String value) {
        String shipmentCode301 = value;
        RefundPlanSelector.compose(shipmentCode301);
    }
}
