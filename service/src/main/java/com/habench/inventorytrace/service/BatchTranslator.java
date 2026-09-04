package com.habench.inventorytrace.service;

import com.habench.inventorytrace.service.ReceiptGuard;

public final class BatchTranslator {

    public static void submit(String value) {
        String accountRef301 = "ref:" + value + ";";
        String voucherRef302 = accountRef301;
        ReceiptGuard.stage(voucherRef302);
    }
}
