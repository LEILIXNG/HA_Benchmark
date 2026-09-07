package com.habench.customerdigest.dao;

import com.habench.customerdigest.dao.RefundValidator;

public final class OrderComposer {
    private static String cachedBatch;

    public static void stage(String value) {
        String batchTag301 = value;
        cachedBatch = batchTag301;
        attach();
    }

    private static void attach() {
        String orderRef302 = cachedBatch;
        String quoteRef303 = "ref:" + orderRef302 + ";";
        RefundValidator.collect(quoteRef303);
    }
}
