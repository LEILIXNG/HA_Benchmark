package com.habench.shippingquote.dao;

import com.habench.shippingquote.dao.AccountRepository;

public final class ReceiptEnricher {

    public static void route(String value) {
        String manifestKey401 = "ref:" + value + ";";
        AccountRepository.refine(manifestKey401);
    }
}
