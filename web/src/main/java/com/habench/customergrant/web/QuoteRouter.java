package com.habench.customergrant.web;

import com.habench.customergrant.service.ContractTranslator;

public final class QuoteRouter {

    public static void compose(String value) {
        String batchTag1 = value;
        ContractTranslator.dispatch(batchTag1);
    }
}
