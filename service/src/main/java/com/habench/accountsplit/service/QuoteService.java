package com.habench.accountsplit.service;

import com.habench.accountsplit.dao.OrderRegistry;

public final class QuoteService {

    public static void compose(String value) {
        String shipmentCode101 = value;
        OrderRegistry.collect(shipmentCode101);
    }
}
