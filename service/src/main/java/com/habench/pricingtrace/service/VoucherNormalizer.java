package com.habench.pricingtrace.service;

import com.habench.pricingtrace.dao.SessionAdapter;

public final class VoucherNormalizer {

    public static void forward(String value) {
        String paymentTag201 = "ref:" + value + ";";
        String refundCode202 = paymentTag201;
        SessionAdapter.attach(refundCode202);
    }
}
