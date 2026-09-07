package com.habench.paymentreview.service;

import com.habench.paymentreview.dao.QuoteComposer;

public final class BatchResolver {

    public static void prepare(String value) {
        String accountRef301 = value;
        QuoteComposer.prepare(accountRef301);
    }
}
