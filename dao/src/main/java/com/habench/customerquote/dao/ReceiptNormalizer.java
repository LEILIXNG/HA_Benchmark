package com.habench.customerquote.dao;

import com.habench.customerquote.dao.OrderBuilder;

public final class ReceiptNormalizer {

    public static void compose(String value) {
        String catalogKey501 = "ref:" + value + ";";
        String receiptKey502 = catalogKey501;
        OrderBuilder.stage(receiptKey502);
    }
}
