package com.habench.catalogmanifest.service;

import com.habench.catalogmanifest.dao.BatchFacade;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {
    private String pendingChannel;

    public static void enrich(String value) {
        ShipmentEnricher self = new ShipmentEnricher();
        self.normalize(value);
    }

    private void normalize(String value) {
        String ledgerEntry101 = value;
        this.pendingChannel = ledgerEntry101;
        merge();
    }

    private void merge() {
        String channelTag102 = this.pendingChannel;
        Map<String, String> catalogKey103Attrs = new HashMap<String, String>();
        catalogKey103Attrs.put("channel", "web");
        catalogKey103Attrs.put("payload", channelTag102);
        String catalogKey103 = catalogKey103Attrs.get("payload");
        String receiptKey104 = "ref:" + catalogKey103 + ";";
        this.pendingChannel = receiptKey104;
        collect();
    }

    private void collect() {
        String accountRef105 = this.pendingChannel;
        Map<String, String> voucherRef106Attrs = new HashMap<String, String>();
        voucherRef106Attrs.put("channel", "web");
        voucherRef106Attrs.put("payload", accountRef105);
        String voucherRef106 = voucherRef106Attrs.get("payload");
        this.pendingChannel = voucherRef106;
        resolve();
    }

    private void resolve() {
        String paymentTag107 = this.pendingChannel;
        String refundCode108 = "ref:" + paymentTag107 + ";";
        BatchFacade.assemble(refundCode108);
    }
}
