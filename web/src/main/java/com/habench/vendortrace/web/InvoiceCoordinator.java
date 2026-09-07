package com.habench.vendortrace.web;

import com.habench.vendortrace.service.SessionEnricher;

public final class InvoiceCoordinator {

    public static void attach(String value) {
        String receiptKey101 = value;
        SessionEnricher.prepare(receiptKey101);
    }
}
