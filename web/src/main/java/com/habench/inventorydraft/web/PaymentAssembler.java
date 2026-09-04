package com.habench.inventorydraft.web;

import com.habench.inventorydraft.service.VoucherRegistry;
import java.util.HashMap;
import java.util.Map;

public final class PaymentAssembler {
    private String pendingShipment;

    public static void translate(String value) {
        PaymentAssembler self = new PaymentAssembler();
        self.forward(value);
    }

    private void forward(String value) {
        String shipmentCode1 = value;
        this.pendingShipment = shipmentCode1;
        refine();
    }

    private void refine() {
        String manifestKey2 = this.pendingShipment;
        Map<String, String> invoiceKey3Attrs = new HashMap<String, String>();
        invoiceKey3Attrs.put("channel", "web");
        invoiceKey3Attrs.put("payload", manifestKey2);
        String invoiceKey3 = invoiceKey3Attrs.get("payload");
        String batchTag4 = invoiceKey3;
        VoucherRegistry.collect(batchTag4);
    }
}
