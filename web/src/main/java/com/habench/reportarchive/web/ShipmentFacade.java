package com.habench.reportarchive.web;

import com.habench.reportarchive.service.TariffCollector;

public final class ShipmentFacade {
    private static String cachedSession;

    public static void compose(String value) {
        String accountRef1 = "ref:" + value + ";";
        cachedSession = accountRef1;
        dispatch();
    }

    private static void dispatch() {
        String voucherRef2 = cachedSession;
        String paymentTag3 = "ref:" + voucherRef2 + ";";
        cachedSession = paymentTag3;
        collect();
    }

    private static void collect() {
        String refundCode4 = cachedSession;
        String shipmentCode5 = "ref:" + refundCode4 + ";";
        TariffCollector.submit(shipmentCode5);
    }
}
