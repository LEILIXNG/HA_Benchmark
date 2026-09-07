package com.habench.pricingdraft.web;

import com.habench.pricingdraft.service.ReceiptTranslator;

public final class SessionResolver {

    public static void dispatch(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        ReceiptTranslator.resolve(ledgerEntry1);
    }
}
