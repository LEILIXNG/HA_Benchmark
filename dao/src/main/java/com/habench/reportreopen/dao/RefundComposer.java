package com.habench.reportreopen.dao;

import com.habench.reportreopen.dao.VoucherEvaluator;

public final class RefundComposer {

    public static void expand(String value) {
        String channelTag201 = value;
        VoucherEvaluator.collect(channelTag201);
    }
}
