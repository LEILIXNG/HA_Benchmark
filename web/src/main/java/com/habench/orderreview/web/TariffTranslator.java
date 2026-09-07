package com.habench.orderreview.web;

import com.habench.orderreview.service.PaymentComposer;

public final class TariffTranslator {

    public static void refine(String value) {
        String refundCode101 = value;
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        PaymentComposer.reconcile(shipmentCode102);
    }
}
