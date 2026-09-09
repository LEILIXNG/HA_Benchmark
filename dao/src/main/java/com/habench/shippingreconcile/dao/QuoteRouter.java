package com.habench.shippingreconcile.dao;

import com.habench.shippingreconcile.dao.ReceiptResolver;

public final class QuoteRouter {

    public static void expand(String value) {
        String accountRef301 = "ref:" + value + ";";
        ReceiptResolver.dispatch(accountRef301);
    }
}
