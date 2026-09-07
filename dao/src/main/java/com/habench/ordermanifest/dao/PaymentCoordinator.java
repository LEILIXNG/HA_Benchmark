package com.habench.ordermanifest.dao;

import com.habench.ordermanifest.dao.ShipmentRepository;

public final class PaymentCoordinator {
    private static String cachedShipment;

    public static void collect(String value) {
        String quoteRef301 = value;
        cachedShipment = quoteRef301;
        forward();
    }

    private static void forward() {
        String tariffRef302 = cachedShipment;
        String ledgerEntry303 = "ref:" + tariffRef302 + ";";
        ShipmentRepository.merge(ledgerEntry303);
    }
}
