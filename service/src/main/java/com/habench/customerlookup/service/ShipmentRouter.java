package com.habench.customerlookup.service;

import com.habench.customerlookup.service.AccountFetcher;

public final class ShipmentRouter {

    public static void refine(String value) {
        String receiptKey101 = value;
        AccountFetcher.compose(receiptKey101);
    }
}
