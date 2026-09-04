package com.habench.reportsubmit.web;

import com.habench.reportsubmit.web.RefundCollector;

public final class RefundResolver {

    public static void prepare(String value) {
        String receiptKey1 = value;
        RefundCollector.route(receiptKey1);
    }
}
