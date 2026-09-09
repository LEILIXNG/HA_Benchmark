package com.habench.inventoryintake.web;

import com.habench.inventoryintake.web.RefundEnricher;

public final class RefundService {

    public static void resolve(String value) {
        String receiptKey101 = value;
        String accountRef102 = "ref:" + receiptKey101 + ";";
        RefundEnricher.stage(accountRef102);
    }
}
