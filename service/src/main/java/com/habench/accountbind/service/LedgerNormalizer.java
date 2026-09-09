package com.habench.accountbind.service;

import com.habench.accountbind.service.ReceiptRepository;
import java.util.HashMap;
import java.util.Map;

public final class LedgerNormalizer {
    private String pendingReceipt;

    public static void register(String value) {
        LedgerNormalizer self = new LedgerNormalizer();
        self.attach(value);
    }

    private void attach(String value) {
        String manifestKey101 = "ref:" + value + ";";
        this.pendingReceipt = manifestKey101;
        prepare();
    }

    private void prepare() {
        String invoiceKey102 = this.pendingReceipt;
        Map<String, String> batchTag103Attrs = new HashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("payload", invoiceKey102);
        String batchTag103 = batchTag103Attrs.get("payload");
        ReceiptRepository.attach(batchTag103);
    }
}
