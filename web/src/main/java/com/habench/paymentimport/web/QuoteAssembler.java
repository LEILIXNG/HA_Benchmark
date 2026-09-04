package com.habench.paymentimport.web;

import com.habench.paymentimport.service.OrderEnricher;

public final class QuoteAssembler {

    public static void collect(String value) {
        String orderRef1 = "ref:" + value + ";";
        String quoteRef2 = "ref:" + orderRef1 + ";";
        OrderEnricher.forward(quoteRef2);
    }
}
