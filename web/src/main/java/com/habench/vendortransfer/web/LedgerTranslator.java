package com.habench.vendortransfer.web;

import com.habench.vendortransfer.web.LedgerExecutor;
import java.util.HashMap;
import java.util.Map;

public final class LedgerTranslator {
    private String pendingLedger;
    private static String cachedLedger;

    public static void resolve(String value) {
        LedgerTranslator self = new LedgerTranslator();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        cachedLedger = manifestKey1;
        compose();
    }

    private void compose() {
        String invoiceKey2 = cachedLedger;
        Map<String, String> batchTag3Attrs = new HashMap<String, String>();
        batchTag3Attrs.put("channel", "web");
        batchTag3Attrs.put("payload", invoiceKey2);
        String batchTag3 = batchTag3Attrs.get("payload");
        Map<String, String> orderRef4Attrs = new HashMap<String, String>();
        orderRef4Attrs.put("channel", "web");
        orderRef4Attrs.put("payload", batchTag3);
        String orderRef4 = orderRef4Attrs.get("payload");
        this.pendingLedger = orderRef4;
        enrich();
    }

    private void enrich() {
        String quoteRef5 = this.pendingLedger;
        String tariffRef6 = "ref:" + quoteRef5 + ";";
        String ledgerEntry7 = tariffRef6;
        LedgerExecutor.dispatch(ledgerEntry7);
    }
}
