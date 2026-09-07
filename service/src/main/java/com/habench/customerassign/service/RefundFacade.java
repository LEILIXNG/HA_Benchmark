package com.habench.customerassign.service;

import com.habench.customerassign.service.InvoiceStrategySelector;

public final class RefundFacade {

    public static void attach(String value) {
        String tariffRef201 = "ref:" + value + ";";
        String ledgerEntry202 = "ref:" + tariffRef201 + ";";
        InvoiceStrategySelector.reconcile(ledgerEntry202);
    }
}
