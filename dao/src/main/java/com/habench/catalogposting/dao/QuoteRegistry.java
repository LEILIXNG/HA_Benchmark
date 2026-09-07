package com.habench.catalogposting.dao;

import com.habench.catalogposting.dao.OrderPlanSelector;

public final class QuoteRegistry {

    public static void dispatch(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        OrderPlanSelector.expand(invoiceKey201);
    }
}
