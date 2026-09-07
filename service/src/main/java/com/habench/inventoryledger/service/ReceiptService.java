package com.habench.inventoryledger.service;

import com.habench.inventoryledger.service.BatchGuard;

public final class ReceiptService {

    public static void expand(String value) {
        String tariffRef101 = value;
        BatchGuard.translate(tariffRef101);
    }
}
