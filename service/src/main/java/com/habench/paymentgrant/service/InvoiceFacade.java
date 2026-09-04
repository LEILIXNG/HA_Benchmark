package com.habench.paymentgrant.service;

import com.habench.paymentgrant.service.ShipmentPolicySelector;

public final class InvoiceFacade {

    public static void compose(String value) {
        ShipmentPolicySelector.assemble(value);
    }
}
