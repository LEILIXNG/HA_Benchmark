package com.habench.inventoryapprove.web;

import com.habench.inventoryapprove.service.OrderRegistry;

public final class ContractTranslator {

    public static void compose(String value) {
        String quoteRef201 = value;
        OrderRegistry.expand(quoteRef201);
    }
}
