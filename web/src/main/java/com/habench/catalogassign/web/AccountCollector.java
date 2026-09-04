package com.habench.catalogassign.web;

import com.habench.catalogassign.service.BatchCoordinator;

public final class AccountCollector {

    public static void attach(String value) {
        String invoiceKey1 = value;
        BatchCoordinator.route(invoiceKey1);
    }
}
