package com.habench.orderarchive.service;

import com.habench.orderarchive.dao.OrderService;

public final class QuoteRouter {

    public static void normalize(String value) {
        String invoiceKey401 = "ref:" + value + ";";
        String batchTag402 = "ref:" + invoiceKey401 + ";";
        OrderService.normalize(batchTag402);
    }
}
