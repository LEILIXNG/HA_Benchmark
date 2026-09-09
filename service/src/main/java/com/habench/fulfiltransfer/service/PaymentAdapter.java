package com.habench.fulfiltransfer.service;

import com.habench.fulfiltransfer.service.ContractCollector;

public final class PaymentAdapter {

    public static void translate(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        String manifestKey102 = shipmentCode101;
        ContractCollector.dispatch(manifestKey102);
    }
}
