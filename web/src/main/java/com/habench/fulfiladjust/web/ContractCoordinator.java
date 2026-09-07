package com.habench.fulfiladjust.web;

import com.habench.fulfiladjust.service.ReceiptCollector;

public final class ContractCoordinator {

    public static void assemble(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        ReceiptCollector.expand(shipmentCode1);
    }
}
