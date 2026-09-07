package com.habench.ordernotice.service;

import com.habench.ordernotice.dao.SessionAssembler;

public final class LedgerAdapter {

    public static void merge(String value) {
        String paymentTag301 = "ref:" + value + ";";
        String refundCode302 = paymentTag301;
        SessionAssembler.reconcile(refundCode302);
    }
}
