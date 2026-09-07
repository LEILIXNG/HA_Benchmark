package com.habench.reportdigest.web;

import com.habench.reportdigest.service.QuoteAssembler;

public final class PaymentService {

    public static void merge(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        String batchTag2 = invoiceKey1;
        QuoteAssembler.stage(batchTag2);
    }
}
