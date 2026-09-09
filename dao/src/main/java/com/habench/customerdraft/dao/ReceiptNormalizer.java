package com.habench.customerdraft.dao;

import com.habench.customerdraft.dao.OrderBuilder;

public final class ReceiptNormalizer {

    public static void compose(String value) {
        String catalogKey501 = "ref:" + value + ";";
        String receiptKey502 = catalogKey501;
        OrderBuilder.stage(receiptKey502);
    }
}
