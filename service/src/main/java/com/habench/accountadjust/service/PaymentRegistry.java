package com.habench.accountadjust.service;

import com.habench.accountadjust.dao.ShipmentEnricher;

public final class PaymentRegistry {

    public static void enrich(String value) {
        String tariffRef201 = value;
        ShipmentEnricher.forward(tariffRef201);
    }
}
