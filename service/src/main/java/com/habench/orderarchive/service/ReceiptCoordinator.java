package com.habench.orderarchive.service;

import com.habench.orderarchive.service.TariffCollector;

public final class ReceiptCoordinator {
    private static String cachedOrder;

    public static void collect(String value) {
        String tariffRef201 = value;
        cachedOrder = tariffRef201;
        dispatch();
    }

    private static void dispatch() {
        String ledgerEntry202 = cachedOrder;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        cachedOrder = channelTag203;
        prepare();
    }

    private static void prepare() {
        String catalogKey204 = cachedOrder;
        String receiptKey205 = catalogKey204;
        String accountRef206 = receiptKey205;
        cachedOrder = accountRef206;
        refine();
    }

    private static void refine() {
        String voucherRef207 = cachedOrder;
        String paymentTag208 = voucherRef207;
        cachedOrder = paymentTag208;
        route();
    }

    private static void route() {
        String refundCode209 = cachedOrder;
        String shipmentCode210 = refundCode209;
        TariffCollector.attach(shipmentCode210);
    }
}
