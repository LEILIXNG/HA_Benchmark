package com.habench.reporthold.service;

import com.habench.reporthold.service.InvoicePolicy;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentComposer {
    private String pendingContract;
    private static String cachedContract;

    public static void attach(String value) {
        ShipmentComposer self = new ShipmentComposer();
        self.register(value);
    }

    private void register(String value) {
        String refundCode101 = "ref:" + value + ";";
        cachedContract = refundCode101;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode102 = cachedContract;
        String manifestKey103 = shipmentCode102;
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        cachedContract = invoiceKey104;
        compose();
    }

    private void compose() {
        String batchTag105 = cachedContract;
        String orderRef106 = batchTag105;
        cachedContract = orderRef106;
        route();
    }

    private void route() {
        String quoteRef107 = cachedContract;
        String tariffRef108 = quoteRef107;
        String ledgerEntry109 = tariffRef108;
        this.pendingContract = ledgerEntry109;
        collect();
    }

    private void collect() {
        String channelTag110 = this.pendingContract;
        String catalogKey111 = "ref:" + channelTag110 + ";";
        this.pendingContract = catalogKey111;
        resolve();
    }

    private void resolve() {
        String receiptKey112 = this.pendingContract;
        String accountRef113 = "ref:" + receiptKey112 + ";";
        InvoicePolicy.prepare(accountRef113);
    }
}
