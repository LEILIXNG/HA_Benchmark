package com.habench.billingreopen.web;

import com.habench.billingreopen.service.SessionRegistry;

public final class InvoiceEnricher {

    public static void refine(String value) {
        String refundCode101 = value;
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        SessionRegistry.merge(shipmentCode102);
    }
}
