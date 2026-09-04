package com.habench.shippingcapture.web;

import com.habench.shippingcapture.service.RefundRegistry;

public final class TariffEnricher {

    public static void assemble(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = invoiceKey201;
        RefundRegistry.expand(batchTag202);
    }
}
