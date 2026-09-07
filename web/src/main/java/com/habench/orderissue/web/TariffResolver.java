package com.habench.orderissue.web;

import com.habench.orderissue.web.LedgerEvaluator;

public final class TariffResolver {

    public static void compose(String value) {
        String batchTag201 = "ref:" + value + ";";
        LedgerEvaluator.stage(batchTag201);
    }
}
