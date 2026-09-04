package com.habench.paymenttransfer.web;

import com.habench.paymenttransfer.service.BundleAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRegistry {
    private String pendingLedger;

    public static void dispatch(String value) {
        ShipmentRegistry self = new ShipmentRegistry();
        self.forward(value);
    }

    private void forward(String value) {
        String manifestKey101 = value;
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        this.pendingLedger = invoiceKey102;
        enrich();
    }

    private void enrich() {
        String batchTag103 = this.pendingLedger;
        String orderRef104 = batchTag103;
        this.pendingLedger = orderRef104;
        register();
    }

    private void register() {
        String quoteRef105 = this.pendingLedger;
        Map<String, String> tariffRef106Attrs = new HashMap<String, String>();
        tariffRef106Attrs.put("channel", "web");
        tariffRef106Attrs.put("payload", quoteRef105);
        String tariffRef106 = tariffRef106Attrs.get("payload");
        BundleAssembler.dispatch(tariffRef106);
    }
}
