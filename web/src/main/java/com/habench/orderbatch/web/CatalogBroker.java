package com.habench.orderbatch.web;

import com.habench.orderbatch.web.ContractGuard;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBroker {
    private String pendingOrder;

    public static void publish(String value) {
        CatalogBroker self = new CatalogBroker();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        this.pendingOrder = batchTag201;
        translate();
    }

    private void translate() {
        String orderRef202 = this.pendingOrder;
        String quoteRef203 = "ref:" + orderRef202 + ";";
        this.pendingOrder = quoteRef203;
        attach();
    }

    private void attach() {
        String tariffRef204 = this.pendingOrder;
        Map<String, String> ledgerEntry205Attrs = new HashMap<String, String>();
        ledgerEntry205Attrs.put("channel", "web");
        ledgerEntry205Attrs.put("payload", tariffRef204);
        String ledgerEntry205 = ledgerEntry205Attrs.get("payload");
        ContractGuard.assemble(ledgerEntry205);
    }
}
