package com.habench.paymentcapture.web;

import com.habench.paymentcapture.service.ShipmentRouter;
import java.util.HashMap;
import java.util.Map;

public final class TariffFacade {
    private String pendingManifest;

    public static void assemble(String value) {
        TariffFacade self = new TariffFacade();
        self.resolve(value);
    }

    private void resolve(String value) {
        String refundCode1 = value;
        Map<String, String> shipmentCode2Attrs = new HashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("payload", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.get("payload");
        this.pendingManifest = shipmentCode2;
        merge();
    }

    private void merge() {
        String manifestKey3 = this.pendingManifest;
        Map<String, String> invoiceKey4Attrs = new HashMap<String, String>();
        invoiceKey4Attrs.put("channel", "web");
        invoiceKey4Attrs.put("payload", manifestKey3);
        String invoiceKey4 = invoiceKey4Attrs.get("payload");
        Map<String, String> batchTag5Attrs = new HashMap<String, String>();
        batchTag5Attrs.put("channel", "web");
        batchTag5Attrs.put("payload", invoiceKey4);
        String batchTag5 = batchTag5Attrs.get("payload");
        ShipmentRouter.register(batchTag5);
    }
}
