package com.habench.shippingtrace.service;

import com.habench.shippingtrace.service.PaymentComposer;

public final class ManifestBuilder {

    public static void forward(String value) {
        String tariffRef101 = "ref:" + value + ";";
        PaymentComposer.forward(tariffRef101);
    }
}
