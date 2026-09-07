package com.habench.paymenttrace.service;

import com.habench.paymenttrace.service.SessionEvaluator;

public final class InvoiceService {

    public static void prepare(String value) {
        String ledgerEntry301 = value;
        String channelTag302 = ledgerEntry301;
        SessionEvaluator.publish(channelTag302);
    }
}
