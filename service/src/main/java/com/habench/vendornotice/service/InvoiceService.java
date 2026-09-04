package com.habench.vendornotice.service;

import com.habench.vendornotice.service.RefundService;

public final class InvoiceService {

    public static void publish(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        String channelTag102 = ledgerEntry101;
        RefundService.normalize(channelTag102);
    }
}
