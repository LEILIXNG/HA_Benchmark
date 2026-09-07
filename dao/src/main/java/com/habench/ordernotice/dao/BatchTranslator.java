package com.habench.ordernotice.dao;

import com.habench.ordernotice.dao.ReceiptEvaluator;

public final class BatchTranslator {

    public static void resolve(String value) {
        String batchTag501 = value;
        ReceiptEvaluator.register(batchTag501);
    }
}
