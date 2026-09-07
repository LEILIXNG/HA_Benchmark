package com.habench.customertransfer.web;

import com.habench.customertransfer.service.BatchResolver;
import java.util.HashMap;
import java.util.Map;

public final class LedgerBroker {
    private String pendingAccount;
    private static String cachedAccount;

    public static void translate(String value) {
        LedgerBroker self = new LedgerBroker();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        cachedAccount = shipmentCode1;
        stage();
    }

    private void stage() {
        String manifestKey2 = cachedAccount;
        Map<String, String> invoiceKey3Attrs = new HashMap<String, String>();
        invoiceKey3Attrs.put("channel", "web");
        invoiceKey3Attrs.put("payload", manifestKey2);
        String invoiceKey3 = invoiceKey3Attrs.get("payload");
        String batchTag4 = invoiceKey3;
        this.pendingAccount = batchTag4;
        forward();
    }

    private void forward() {
        String orderRef5 = this.pendingAccount;
        String quoteRef6 = orderRef5;
        BatchResolver.attach(quoteRef6);
    }
}
