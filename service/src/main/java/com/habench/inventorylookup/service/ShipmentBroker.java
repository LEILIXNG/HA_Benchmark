package com.habench.inventorylookup.service;

import com.habench.inventorylookup.dao.ReceiptCollector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {
    private String pendingBatch;
    private static String cachedBatch;

    public static void merge(String value) {
        ShipmentBroker self = new ShipmentBroker();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        String voucherRef202 = "ref:" + accountRef201 + ";";
        cachedBatch = voucherRef202;
        route();
    }

    private void route() {
        String paymentTag203 = cachedBatch;
        Map<String, String> refundCode204Attrs = new HashMap<String, String>();
        refundCode204Attrs.put("channel", "web");
        refundCode204Attrs.put("payload", paymentTag203);
        String refundCode204 = refundCode204Attrs.get("payload");
        String shipmentCode205 = "ref:" + refundCode204 + ";";
        this.pendingBatch = shipmentCode205;
        compose();
    }

    private void compose() {
        String manifestKey206 = this.pendingBatch;
        String invoiceKey207 = "ref:" + manifestKey206 + ";";
        Map<String, String> batchTag208Attrs = new HashMap<String, String>();
        batchTag208Attrs.put("channel", "web");
        batchTag208Attrs.put("payload", invoiceKey207);
        String batchTag208 = batchTag208Attrs.get("payload");
        ReceiptCollector.collect(batchTag208);
    }
}
