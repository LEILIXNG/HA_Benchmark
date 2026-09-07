package com.habench.paymentsync.dao;

import com.habench.paymentsync.dao.ReceiptRepository;

public final class LedgerNormalizer {

    public static void attach(String value) {
        String tariffRef301 = value;
        String ledgerEntry302 = "ref:" + tariffRef301 + ";";
        ReceiptRepository.attach(ledgerEntry302);
    }
}
