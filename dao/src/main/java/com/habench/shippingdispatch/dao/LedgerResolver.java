package com.habench.shippingdispatch.dao;

import com.habench.shippingdispatch.dao.OrderPolicy;

public final class LedgerResolver {

    public static void route(String value) {
        String accountRef401 = "ref:" + value + ";";
        OrderPolicy.stage(accountRef401);
    }
}
