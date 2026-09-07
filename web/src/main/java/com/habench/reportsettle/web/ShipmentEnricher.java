package com.habench.reportsettle.web;

import com.habench.reportsettle.web.VoucherCollector;

public final class ShipmentEnricher {
    private static String cachedChannel;

    public static void submit(String value) {
        String refundCode1 = "ref:" + value + ";";
        String shipmentCode2 = refundCode1;
        cachedChannel = shipmentCode2;
        assemble();
    }

    private static void assemble() {
        String manifestKey3 = cachedChannel;
        String invoiceKey4 = manifestKey3;
        String batchTag5 = "ref:" + invoiceKey4 + ";";
        VoucherCollector.prepare(batchTag5);
    }
}
