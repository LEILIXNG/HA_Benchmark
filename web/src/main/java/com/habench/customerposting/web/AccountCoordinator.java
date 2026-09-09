package com.habench.customerposting.web;

import com.habench.customerposting.web.VoucherAdapter;

public final class AccountCoordinator {

    public static void reconcile(String value) {
        String catalogKey1 = value;
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        VoucherAdapter.forward(receiptKey2);
    }
}
