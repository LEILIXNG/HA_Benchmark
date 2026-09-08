package com.habench.customersettle.service;

import com.habench.customersettle.service.ShipmentRepository;
import java.util.HashMap;
import java.util.Map;

public final class RefundComposer {
    private String pendingShipment;

    public static void compose(String value) {
        RefundComposer self = new RefundComposer();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        Map<String, String> invoiceKey202Attrs = new HashMap<String, String>();
        invoiceKey202Attrs.put("channel", "web");
        invoiceKey202Attrs.put("payload", manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get("payload");
        this.pendingShipment = invoiceKey202;
        translate();
    }

    private void translate() {
        String batchTag203 = this.pendingShipment;
        String orderRef204 = batchTag203;
        Map<String, String> quoteRef205Attrs = new HashMap<String, String>();
        quoteRef205Attrs.put("channel", "web");
        quoteRef205Attrs.put("payload", orderRef204);
        String quoteRef205 = quoteRef205Attrs.get("payload");
        ShipmentRepository.prepare(quoteRef205);
    }
}
