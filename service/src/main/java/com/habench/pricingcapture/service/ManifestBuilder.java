package com.habench.pricingcapture.service;

import com.habench.pricingcapture.service.PaymentComposer;

public final class ManifestBuilder {

    public static void forward(String value) {
        String tariffRef101 = "ref:" + value + ";";
        PaymentComposer.forward(tariffRef101);
    }
}
