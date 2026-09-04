package com.habench.pricingadjust.service;

import com.habench.pricingadjust.service.PaymentPlanSelector;

public final class ReceiptBuilder {

    public static void publish(String value) {
        String refundCode201 = "ref:" + value + ";";
        PaymentPlanSelector.normalize(refundCode201);
    }
}
