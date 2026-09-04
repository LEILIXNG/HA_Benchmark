package com.habench.paymentrollup.web;

import com.habench.paymentrollup.web.AccountNormalizer;

public final class ContractBuilder {

    public static void submit(String value) {
        AccountNormalizer.register(value);
    }
}
