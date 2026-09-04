package com.habench.fulfilposting.web;

import com.habench.fulfilposting.web.LedgerService;

public final class ReceiptService {

    public static void dispatch(String value) {
        String catalogKey101 = "ref:" + value + ";";
        String receiptKey102 = catalogKey101;
        LedgerService.merge(receiptKey102);
    }
}
