package com.habench.vendorissue.service;

import com.habench.vendorissue.service.PaymentRuleSelector;

public final class ChannelCoordinator {
    private static String cachedTariff;

    public static void resolve(String value) {
        String refundCode301 = "ref:" + value + ";";
        String shipmentCode302 = refundCode301;
        cachedTariff = shipmentCode302;
        enrich();
    }

    private static void enrich() {
        String manifestKey303 = cachedTariff;
        String invoiceKey304 = "ref:" + manifestKey303 + ";";
        String batchTag305 = invoiceKey304;
        PaymentRuleSelector.enrich(batchTag305);
    }
}
