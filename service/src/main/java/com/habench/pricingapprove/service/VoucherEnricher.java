package com.habench.pricingapprove.service;

import com.habench.pricingapprove.service.BatchEnricher;

public final class VoucherEnricher {

    public static void resolve(String value) {
        String quoteRef101 = "ref:" + value + ";";
        String tariffRef102 = quoteRef101;
        BatchEnricher.submit(tariffRef102);
    }
}
