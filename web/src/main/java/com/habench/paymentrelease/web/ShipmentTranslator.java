package com.habench.paymentrelease.web;

import com.habench.paymentrelease.web.ContractExecutor;

public final class ShipmentTranslator {

    public static void prepare(String value) {
        String catalogKey201 = value;
        ContractExecutor.dispatch(catalogKey201);
    }
}
