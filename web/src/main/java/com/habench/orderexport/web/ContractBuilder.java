package com.habench.orderexport.web;

import com.habench.orderexport.web.AccountNormalizer;

public final class ContractBuilder {

    public static void submit(String value) {
        AccountNormalizer.register(value);
    }
}
