package com.habench.accountsettle.service;

import com.habench.accountsettle.service.VoucherResolver;
import java.util.HashMap;
import java.util.Map;

public final class BatchAssembler {
    private String pendingSession;

    public static void compose(String value) {
        BatchAssembler self = new BatchAssembler();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String orderRef301 = "ref:" + value + ";";
        String quoteRef302 = "ref:" + orderRef301 + ";";
        this.pendingSession = quoteRef302;
        expand();
    }

    private void expand() {
        String tariffRef303 = this.pendingSession;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        VoucherResolver.prepare(ledgerEntry304);
    }
}
