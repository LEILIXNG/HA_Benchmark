package com.habench.billingsync.service;

import com.habench.billingsync.service.ChannelPlanSelector;

public final class ShipmentBuilder {
    private static String cachedReceipt;

    public static void publish(String value) {
        String refundCode101 = value;
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        cachedReceipt = shipmentCode102;
        reconcile();
    }

    private static void reconcile() {
        String manifestKey103 = cachedReceipt;
        String invoiceKey104 = manifestKey103;
        ChannelPlanSelector.forward(invoiceKey104);
    }
}
