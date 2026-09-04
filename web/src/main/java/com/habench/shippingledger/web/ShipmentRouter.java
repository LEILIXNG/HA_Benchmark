package com.habench.shippingledger.web;

import com.habench.shippingledger.service.ContractResolver;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {
    private String pendingBatch;

    public static void merge(String value) {
        ShipmentRouter self = new ShipmentRouter();
        self.normalize(value);
    }

    private void normalize(String value) {
        String refundCode101 = value;
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        this.pendingBatch = shipmentCode102;
        attach();
    }

    private void attach() {
        String manifestKey103 = this.pendingBatch;
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        this.pendingBatch = invoiceKey104;
        enrich();
    }

    private void enrich() {
        String batchTag105 = this.pendingBatch;
        String orderRef106 = batchTag105;
        this.pendingBatch = orderRef106;
        register();
    }

    private void register() {
        String quoteRef107 = this.pendingBatch;
        String tariffRef108 = quoteRef107;
        Map<String, String> ledgerEntry109Attrs = new HashMap<String, String>();
        ledgerEntry109Attrs.put("channel", "web");
        ledgerEntry109Attrs.put("payload", tariffRef108);
        String ledgerEntry109 = ledgerEntry109Attrs.get("payload");
        ContractResolver.dispatch(ledgerEntry109);
    }
}
