package com.habench.fulfilsubmit.service;

import com.habench.fulfilsubmit.service.BundlePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentFacade {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void prepare(String value) {
        ShipmentFacade self = new ShipmentFacade();
        self.attach(value);
    }

    private void attach(String value) {
        String voucherRef101 = value;
        cachedReceipt = voucherRef101;
        merge();
    }

    private void merge() {
        String paymentTag102 = cachedReceipt;
        String refundCode103 = paymentTag102;
        this.pendingReceipt = refundCode103;
        route();
    }

    private void route() {
        String shipmentCode104 = this.pendingReceipt;
        Map<String, String> manifestKey105Attrs = new HashMap<String, String>();
        manifestKey105Attrs.put("channel", "web");
        manifestKey105Attrs.put("payload", shipmentCode104);
        String manifestKey105 = manifestKey105Attrs.get("payload");
        this.pendingReceipt = manifestKey105;
        forward();
    }

    private void forward() {
        String invoiceKey106 = this.pendingReceipt;
        String batchTag107 = "ref:" + invoiceKey106 + ";";
        String orderRef108 = batchTag107;
        BundlePolicySelector.submit(orderRef108);
    }
}
