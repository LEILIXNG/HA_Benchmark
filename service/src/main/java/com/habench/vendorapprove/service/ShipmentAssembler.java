package com.habench.vendorapprove.service;

import com.habench.vendorapprove.service.ContractBuilder;

public final class ShipmentAssembler {

    public static void reconcile(String value) {
        String receiptKey301 = value;
        ContractBuilder.expand(receiptKey301);
    }
}
