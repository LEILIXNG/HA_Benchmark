package com.habench.shippingadjust.web;

import com.habench.shippingadjust.service.BatchService;
import java.util.HashMap;
import java.util.Map;

public final class OrderNormalizer {
    private String pendingContract;
    private static String cachedContract;

    public static void normalize(String value) {
        OrderNormalizer self = new OrderNormalizer();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String voucherRef1 = value;
        cachedContract = voucherRef1;
        publish();
    }

    private void publish() {
        String paymentTag2 = cachedContract;
        String refundCode3 = paymentTag2;
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("payload", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("payload");
        this.pendingContract = shipmentCode4;
        register();
    }

    private void register() {
        String manifestKey5 = this.pendingContract;
        Map<String, String> invoiceKey6Attrs = new HashMap<String, String>();
        invoiceKey6Attrs.put("channel", "web");
        invoiceKey6Attrs.put("payload", manifestKey5);
        String invoiceKey6 = invoiceKey6Attrs.get("payload");
        cachedContract = invoiceKey6;
        resolve();
    }

    private void resolve() {
        String batchTag7 = cachedContract;
        Map<String, String> orderRef8Attrs = new HashMap<String, String>();
        orderRef8Attrs.put("channel", "web");
        orderRef8Attrs.put("payload", batchTag7);
        String orderRef8 = orderRef8Attrs.get("payload");
        BatchService.register(orderRef8);
    }
}
