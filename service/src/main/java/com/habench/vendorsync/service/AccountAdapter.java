package com.habench.vendorsync.service;

import com.habench.vendorsync.service.BatchFacade;
import java.util.HashMap;
import java.util.Map;

public final class AccountAdapter {
    private String pendingBatch;
    private static String cachedBatch;

    public static void assemble(String value) {
        AccountAdapter self = new AccountAdapter();
        self.stage(value);
    }

    private void stage(String value) {
        String manifestKey401 = value;
        this.pendingBatch = manifestKey401;
        register();
    }

    private void register() {
        String invoiceKey402 = this.pendingBatch;
        Map<String, String> batchTag403Attrs = new HashMap<String, String>();
        batchTag403Attrs.put("channel", "web");
        batchTag403Attrs.put("payload", invoiceKey402);
        String batchTag403 = batchTag403Attrs.get("payload");
        Map<String, String> orderRef404Attrs = new HashMap<String, String>();
        orderRef404Attrs.put("channel", "web");
        orderRef404Attrs.put("payload", batchTag403);
        String orderRef404 = orderRef404Attrs.get("payload");
        cachedBatch = orderRef404;
        normalize();
    }

    private void normalize() {
        String quoteRef405 = cachedBatch;
        String tariffRef406 = quoteRef405;
        BatchFacade.forward(tariffRef406);
    }
}
