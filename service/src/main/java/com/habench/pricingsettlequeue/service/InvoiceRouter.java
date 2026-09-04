package com.habench.pricingsettlequeue.service;

import com.habench.pricingsettlequeue.service.ReceiptBroker;

public final class InvoiceRouter {

    public static void collect(String value) {
        String paymentTag101 = value;
        String refundCode102 = paymentTag101;
        ReceiptBroker.enrich(refundCode102);
    }
}
