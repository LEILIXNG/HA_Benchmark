package com.habench.shippingquote.web;

import com.habench.shippingquote.service.ManifestComposer;

public final class QuoteBroker {

    public static void enrich(String value) {
        String tariffRef1 = "ref:" + value + ";";
        ManifestComposer.forward(tariffRef1);
    }
}
