package com.habench.vendorverify.web;

import com.habench.vendorverify.web.InvoiceTranslator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAssembler2 {
    private String pendingManifest;

    public static void publish(String value) {
        LedgerAssembler2 self = new LedgerAssembler2();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        String ledgerEntry202 = tariffRef201;
        this.pendingManifest = ledgerEntry202;
        attach();
    }

    private void attach() {
        String channelTag203 = this.pendingManifest;
        String catalogKey204 = channelTag203;
        String receiptKey205 = "ref:" + catalogKey204 + ";";
        InvoiceTranslator.resolve(receiptKey205);
    }
}
