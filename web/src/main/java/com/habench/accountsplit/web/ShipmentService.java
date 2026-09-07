package com.habench.accountsplit.web;

import com.habench.accountsplit.web.ShipmentFilter;

public final class ShipmentService {

    public static void refine(String value) {
        String receiptKey201 = "ref:" + value + ";";
        String accountRef202 = receiptKey201;
        ShipmentFilter.assemble(accountRef202);
    }
}
