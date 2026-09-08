package com.habench.billinggrant.service;

import com.habench.billinggrant.service.BatchGuard;

public final class ReceiptService {

    public static void expand(String value) {
        String tariffRef101 = value;
        BatchGuard.translate(tariffRef101);
    }
}
