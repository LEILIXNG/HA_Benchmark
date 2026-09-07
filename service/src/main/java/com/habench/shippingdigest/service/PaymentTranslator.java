package com.habench.shippingdigest.service;

import com.habench.shippingdigest.dao.QuoteAdapter;

public final class PaymentTranslator {

    public static void forward(String value) {
        String refundCode301 = "ref:" + value + ";";
        QuoteAdapter.collect(refundCode301);
    }
}
