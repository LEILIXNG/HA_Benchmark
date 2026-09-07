package com.habench.ordersync.web;

import com.habench.ordersync.service.VoucherAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCollector {
    private String pendingManifest;
    private static String cachedManifest;

    public static void register(String value) {
        ShipmentCollector self = new ShipmentCollector();
        self.route(value);
    }

    private void route(String value) {
        String ledgerEntry1 = value;
        this.pendingManifest = ledgerEntry1;
        compose();
    }

    private void compose() {
        String channelTag2 = this.pendingManifest;
        String catalogKey3 = "ref:" + channelTag2 + ";";
        Map<String, String> receiptKey4Attrs = new HashMap<String, String>();
        receiptKey4Attrs.put("channel", "web");
        receiptKey4Attrs.put("payload", catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get("payload");
        cachedManifest = receiptKey4;
        normalize();
    }

    private void normalize() {
        String accountRef5 = cachedManifest;
        String voucherRef6 = "ref:" + accountRef5 + ";";
        cachedManifest = voucherRef6;
        reconcile();
    }

    private void reconcile() {
        String paymentTag7 = cachedManifest;
        String refundCode8 = "ref:" + paymentTag7 + ";";
        VoucherAdapter.submit(refundCode8);
    }
}
