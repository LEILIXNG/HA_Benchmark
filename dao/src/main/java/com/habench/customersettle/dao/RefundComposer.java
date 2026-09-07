package com.habench.customersettle.dao;

import com.habench.customersettle.dao.ShipmentRepository;

public final class RefundComposer {
    private static String cachedShipment;

    public static void attach(String value) {
        String accountRef301 = value;
        cachedShipment = accountRef301;
        translate();
    }

    private static void translate() {
        String voucherRef302 = cachedShipment;
        String paymentTag303 = "ref:" + voucherRef302 + ";";
        ShipmentRepository.prepare(paymentTag303);
    }
}
