package com.habench.reportdigest.service;

import com.habench.reportdigest.service.ReceiptFetcher;

public final class LedgerTranslator {
    private static String cachedReceipt;

    public static void normalize(String value) {
        String manifestKey101 = value;
        cachedReceipt = manifestKey101;
        expand();
    }

    private static void expand() {
        String invoiceKey102 = cachedReceipt;
        String batchTag103 = invoiceKey102;
        ReceiptFetcher.submit(batchTag103);
    }
}
