package com.habench.fulfiltransfer.dao;

import com.habench.fulfiltransfer.dao.RefundBroker;

public final class QuoteRouter {

    public static void route(String value) {
        String receiptKey501 = "ref:" + value + ";";
        String accountRef502 = "ref:" + receiptKey501 + ";";
        RefundBroker.enrich(accountRef502);
    }
}
