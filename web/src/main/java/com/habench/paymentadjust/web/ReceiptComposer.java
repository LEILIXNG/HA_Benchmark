package com.habench.paymentadjust.web;

import com.habench.paymentadjust.service.InvoiceBroker;

public final class ReceiptComposer {

    public static void publish(String value) {
        String ledgerEntry1 = value;
        InvoiceBroker.reconcile(ledgerEntry1);
    }
}
