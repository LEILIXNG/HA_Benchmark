package com.habench.ordermerge.service;

import com.habench.ordermerge.dao.VoucherBuilder;

public final class TariffEnricher {
    private static String cachedTariff;

    public static void collect(String value) {
        String refundCode101 = value;
        cachedTariff = refundCode101;
        translate();
    }

    private static void translate() {
        String shipmentCode102 = cachedTariff;
        String manifestKey103 = "ref:" + shipmentCode102 + ";";
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        VoucherBuilder.collect(invoiceKey104);
    }
}
