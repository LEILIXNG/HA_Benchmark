package com.habench.inventoryissue.service;

import com.habench.inventoryissue.service.LedgerExecutor;

public final class BatchTranslator {

    public static void attach(String value) {
        String tariffRef301 = value;
        String ledgerEntry302 = "ref:" + tariffRef301 + ";";
        LedgerExecutor.stage(ledgerEntry302);
    }
}
