package com.habench.accountdraft.dao;

import com.habench.accountdraft.dao.RefundCollector;

public final class OrderBroker {

    public static void attach(String value) {
        String catalogKey201 = value;
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        RefundCollector.route(receiptKey202);
    }
}
