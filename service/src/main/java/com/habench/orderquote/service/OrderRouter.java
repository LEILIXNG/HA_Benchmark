package com.habench.orderquote.service;

import com.habench.orderquote.dao.ReceiptBroker;

public final class OrderRouter {

    public static void enrich(String value) {
        String accountRef201 = value;
        ReceiptBroker.enrich(accountRef201);
    }
}
