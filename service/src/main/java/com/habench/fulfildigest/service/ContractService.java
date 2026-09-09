package com.habench.fulfildigest.service;

import com.habench.fulfildigest.dao.ShipmentService;
import java.util.HashMap;
import java.util.Map;

public final class ContractService {
    private static String cachedReceipt;

    public static void forward(String value) {
        String refundCode101 = "ref:" + value + ";";
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        cachedReceipt = shipmentCode102;
        stage();
    }

    private static void stage() {
        String manifestKey103 = cachedReceipt;
        String invoiceKey104 = manifestKey103;
        Map<String, String> batchTag105Attrs = new HashMap<String, String>();
        batchTag105Attrs.put("channel", "web");
        batchTag105Attrs.put("payload", invoiceKey104);
        String batchTag105 = batchTag105Attrs.get("payload");
        ShipmentService.expand(batchTag105);
    }
}
