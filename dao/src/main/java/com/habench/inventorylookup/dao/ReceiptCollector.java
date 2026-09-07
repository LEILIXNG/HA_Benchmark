package com.habench.inventorylookup.dao;

import com.habench.inventorylookup.dao.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCollector {
    private String pendingBatch;
    private static String cachedBatch;

    public static void collect(String value) {
        ReceiptCollector self = new ReceiptCollector();
        self.compose(value);
    }

    private void compose(String value) {
        String tariffRef301 = value;
        String ledgerEntry302 = tariffRef301;
        cachedBatch = ledgerEntry302;
        assemble();
    }

    private void assemble() {
        String channelTag303 = cachedBatch;
        Map<String, String> catalogKey304Attrs = new HashMap<String, String>();
        catalogKey304Attrs.put("channel", "web");
        catalogKey304Attrs.put("payload", channelTag303);
        String catalogKey304 = catalogKey304Attrs.get("payload");
        this.pendingBatch = catalogKey304;
        translate();
    }

    private void translate() {
        String receiptKey305 = this.pendingBatch;
        String accountRef306 = "ref:" + receiptKey305 + ";";
        BatchExecutor.assemble(accountRef306);
    }
}
