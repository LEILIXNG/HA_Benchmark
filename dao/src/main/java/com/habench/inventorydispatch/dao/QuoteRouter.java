package com.habench.inventorydispatch.dao;

import com.habench.inventorydispatch.dao.ReceiptResolver;

public final class QuoteRouter {

    public static void expand(String value) {
        String accountRef301 = "ref:" + value + ";";
        ReceiptResolver.dispatch(accountRef301);
    }
}
