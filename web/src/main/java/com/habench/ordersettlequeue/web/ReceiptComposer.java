package com.habench.ordersettlequeue.web;

import com.habench.ordersettlequeue.service.InvoiceBroker;

public final class ReceiptComposer {

    public static void publish(String value) {
        String ledgerEntry1 = value;
        InvoiceBroker.reconcile(ledgerEntry1);
    }
}
