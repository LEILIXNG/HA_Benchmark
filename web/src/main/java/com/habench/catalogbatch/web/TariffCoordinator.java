package com.habench.catalogbatch.web;

import com.habench.catalogbatch.service.ReceiptCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class TariffCoordinator {
    private String pendingAccount;

    public static void publish(String value) {
        TariffCoordinator self = new TariffCoordinator();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        this.pendingAccount = batchTag102;
        assemble();
    }

    private void assemble() {
        String orderRef103 = this.pendingAccount;
        Map<String, String> quoteRef104Attrs = new HashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("payload", orderRef103);
        String quoteRef104 = quoteRef104Attrs.get("payload");
        ReceiptCoordinator.translate(quoteRef104);
    }
}
