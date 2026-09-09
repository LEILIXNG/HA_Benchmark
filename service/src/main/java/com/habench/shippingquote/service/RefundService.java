package com.habench.shippingquote.service;

import com.habench.shippingquote.dao.ReceiptEnricher;

public final class RefundService {

    public static void resolve(String value) {
        String tariffRef301 = "ref:" + value + ";";
        ReceiptEnricher.route(tariffRef301);
    }
}
