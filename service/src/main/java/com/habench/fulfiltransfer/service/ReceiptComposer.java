package com.habench.fulfiltransfer.service;

import com.habench.fulfiltransfer.service.TariffResolver;

public final class ReceiptComposer {

    public static void prepare(String value) {
        String ledgerEntry201 = value;
        TariffResolver.reconcile(ledgerEntry201);
    }
}
