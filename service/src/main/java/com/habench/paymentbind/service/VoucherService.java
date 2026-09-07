package com.habench.paymentbind.service;

import com.habench.paymentbind.service.QuoteAdapter;

public final class VoucherService {

    public static void collect(String value) {
        String ledgerEntry101 = value;
        QuoteAdapter.forward(ledgerEntry101);
    }
}
