package com.habench.reportclose.service;

import com.habench.reportclose.service.LedgerService;

public final class BatchAdapter {

    public static void normalize(String value) {
        String orderRef201 = value;
        String quoteRef202 = "ref:" + orderRef201 + ";";
        LedgerService.assemble(quoteRef202);
    }
}
