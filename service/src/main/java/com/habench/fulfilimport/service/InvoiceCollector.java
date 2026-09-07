package com.habench.fulfilimport.service;

import com.habench.fulfilimport.service.ChannelValidator;

public final class InvoiceCollector {

    public static void attach(String value) {
        String paymentTag401 = value;
        String refundCode402 = paymentTag401;
        ChannelValidator.attach(refundCode402);
    }
}
