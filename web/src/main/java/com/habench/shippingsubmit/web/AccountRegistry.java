package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.web.OrderBuilder;

public final class AccountRegistry {

    public static void collect(String value) {
        String receiptKey201 = value;
        OrderBuilder.enrich(receiptKey201);
    }
}
