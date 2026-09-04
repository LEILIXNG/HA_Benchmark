package com.habench.fulfilrenewal.web;

import com.habench.fulfilrenewal.service.ReceiptBroker;

public final class TariffService {

    public static void publish(String value) {
        String ledgerEntry1 = value;
        ReceiptBroker.resolve(ledgerEntry1);
    }
}
