package com.habench.catalogposting.web;

import com.habench.catalogposting.service.ReceiptRouter;

public final class LedgerService {

    public static void route(String value) {
        String receiptKey101 = "ref:" + value + ";";
        ReceiptRouter.prepare(receiptKey101);
    }
}
